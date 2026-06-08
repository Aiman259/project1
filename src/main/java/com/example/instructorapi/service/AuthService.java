package com.example.instructorapi.service;

import com.example.instructorapi.dto.AuthResponse;
import com.example.instructorapi.dto.LoginRequest;
import com.example.instructorapi.dto.RegisterRequest;
import com.example.instructorapi.model.Role;
import com.example.instructorapi.model.User;
import com.example.instructorapi.repository.UserRepository;
import com.example.instructorapi.security.jwt.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // Default sebagai USER
        user.setRole(Role.USER); 

        userRepository.save(user);
        return "User registered successfully";
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Hantar role ke dalam token
        String token = jwtUtils.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole()
        );
    }
}