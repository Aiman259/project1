package com.example.Project_1.controller;

import com.example.Project_1.dto.LoginRequest;
import com.example.Project_1.model.User;
import com.example.Project_1.model.Role;
import com.example.Project_1.repository.UserRepository;
import com.example.Project_1.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        // Mengambil user dari Optional
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);
        
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("email", user.getEmail());
            response.put("role", user.getRole().toString());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Error: Invalid credentials!");
    }

@PostMapping("/register")
public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {

    if (userRepository.existsByEmail(user.getEmail())) {
        return ResponseEntity.badRequest()
                .body("Error: Email is already taken!");
    }
    user.setPassword(
            passwordEncoder.encode(user.getPassword())
    );
    if (user.getRole() == null) {
        user.setRole(Role.USER);
    }
    userRepository.save(user);
    return ResponseEntity.ok(
            "User registered successfully!"
    );
}

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
}