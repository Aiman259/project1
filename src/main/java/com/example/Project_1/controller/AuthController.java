package com.example.Project_1.controller;

import com.example.Project_1.dto.LoginRequest;
import com.example.Project_1.model.User;
import com.example.Project_1.repository.UserRepository;
import com.example.Project_1.util.JwtUtil;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil; // Pastikan hanya satu sahaja autowired untuk JwtUtil

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Error: Email already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User " + user.getName() + " registered successfully!");
    }

@PostMapping("/login")
public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
    // 1. Cari user berdasarkan email
    com.example.Project_1.model.User user = userRepository.findByEmail(loginRequest.getEmail());
    
    // 2. Semak password dan jana token menggunakan objek USER
    if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        String token = jwtUtil.generateToken(user); // <--- Hantar objek user ke sini
        return ResponseEntity.ok("Token: " + token);
    }
    return ResponseEntity.status(401).body("Error: Invalid credentials!");
}
}