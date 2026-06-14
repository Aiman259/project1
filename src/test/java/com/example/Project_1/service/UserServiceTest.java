package com.example.Project_1.service;

import com.example.Project_1.model.User;
import com.example.Project_1.repository.UserRepository;
import com.example.Project_1.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional; // 1. TAMBAH IMPORT INI

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserService userService;

    @Test
    void loginUser_Success() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("encodedPassword");

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("rawPassword", "encodedPassword")).thenReturn(true);
        when(jwtUtil.generateToken(user)).thenReturn("mockedToken");

        // Act
        String token = userService.loginUser("test@example.com", "rawPassword");

        // Assert
        assertEquals("mockedToken", token);
        verify(jwtUtil).generateToken(user);
    }

    @Test
    void loginUser_Failure_UserNotFound() {
        // Arrange
        // 2. TUKAR KEPADA Optional.empty() BUKAN null
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.loginUser("nonexistent@example.com", "anyPassword");
        });
        assertEquals("Invalid credentials!", exception.getMessage());
    }

    @Test
    void loginUser_EdgeCase_IncorrectPassword() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("encodedPassword");

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongPassword", "encodedPassword")).thenReturn(false);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.loginUser("test@example.com", "wrongPassword");
        });
        assertEquals("Invalid credentials!", exception.getMessage());
    }
}