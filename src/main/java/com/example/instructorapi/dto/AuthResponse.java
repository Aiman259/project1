package com.example.instructorapi.dto;

import com.example.instructorapi.model.Role;

public class AuthResponse {
    private String token;
    private String tokenType = "Bearer";
    private String email;
    private Role role;

    // Constructor, Getter & Setter
    public AuthResponse(String token, String email, Role role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
    
    public AuthResponse login(LoginRequest request) {
        // Cuba kod ini, kalau masih merah, letak "null" untuk role
        return new AuthResponse("MOCK_TOKEN_123", request.getEmail(), null);
    }
}