package com.example.instructorapi.controller;

import com.example.instructorapi.dto.AuthResponse;
import com.example.instructorapi.dto.LoginRequest;
import com.example.instructorapi.dto.RegisterRequest;
import com.example.instructorapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerUser(request));
    }

    // Gabungkan login dan try-catch di sini
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok(authService.login(loginRequest));
        } catch (Exception e) {
            e.printStackTrace(); // Sekarang log akan keluar di terminal!
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}