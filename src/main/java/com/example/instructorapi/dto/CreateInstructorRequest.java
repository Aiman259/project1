package com.example.instructorapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateInstructorRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    private String email;
    private String specialization;
    private int yearsExperience;
    private boolean active;
}