package com.example.instructorapi.dto;

public class InstructorStatusSummary {

    private String status;
    private long totalInstructors;

    // Empty Constructor
    public InstructorStatusSummary() {
    }

    // Constructor
    public InstructorStatusSummary(String status, long totalInstructors) {
        this.status = status;
        this.totalInstructors = totalInstructors;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalInstructors() {
        return totalInstructors;
    }

    public void setTotalInstructors(long totalInstructors) {
        this.totalInstructors = totalInstructors;
    }
}