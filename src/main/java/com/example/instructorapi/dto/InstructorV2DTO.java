package com.example.instructorapi.dto;

import lombok.Data;

@Data
public class InstructorV2DTO {
    private String id;
    private String fullName;
    private String primarySkill;
    private String availabilityStatus;
    private String experienceLevel;
    private String profileSummary;

    public InstructorV2DTO(String id, String name, String spec, String status, int years) {
        this.id = id;
        this.fullName = name;
        this.primarySkill = spec;
        this.availabilityStatus = "ACTIVE".equalsIgnoreCase(status) ? "Available for Teaching" : "Busy";
        this.experienceLevel = calculateLevel(years);
        this.profileSummary = name + " specializes in " + spec + " and has " + years + " years of teaching experience.";
    }

    private String calculateLevel(int years) {
        if (years <= 2) return "Junior";
        if (years <= 5) return "Intermediate";
        return "Senior";
    }
}