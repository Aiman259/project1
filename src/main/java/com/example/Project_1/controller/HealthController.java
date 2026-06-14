package com.example.Project_1.controller;

import com.example.Project_1.repository.CourseRepository; // Atau repository yang anda guna

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    // 1. Deklarasikan repository di sini
    private final CourseRepository repository;

    // 2. Gunakan constructor untuk inject repository (Dependency Injection)
    public HealthController(CourseRepository repository) {
        this.repository = repository;
    }

        @GetMapping("/api/health")
public ResponseEntity<Map<String, String>> healthCheck() {
    Map<String, String> response = new HashMap<>();
    response.put("status", "UP");
    return ResponseEntity.ok(response);
}
}
