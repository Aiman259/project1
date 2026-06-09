package com.example.instructorapi.dto;

public class InstructorSpecializationSummary {
    private String specialization;
    private long totalInstructors;

    public InstructorSpecializationSummary() {}

    public InstructorSpecializationSummary(String specialization, long totalInstructors) {
        this.specialization = specialization;
        this.totalInstructors = totalInstructors;
    }

    // Getters and Setters
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public long getTotalInstructors() { return totalInstructors; }
    public void setTotalInstructors(long totalInstructors) { this.totalInstructors = totalInstructors; }
}