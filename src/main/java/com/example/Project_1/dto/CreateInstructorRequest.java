package com.example.Project_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Email; 

public class CreateInstructorRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must contain @") 
    private String email;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @Min(value = 0, message = "Years of experience cannot be negative")
    private int yearsExperience;

    private boolean active; 

    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public int getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}