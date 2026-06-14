package com.example.Project_1.dto;

public class InstructorStatusSummary {
    private String status;
    private long totalInstructors;

    public InstructorStatusSummary() {}

  public InstructorStatusSummary(boolean active, long totalInstructors) {
        this.status = active ? "Active" : "Inactive";
        this.totalInstructors = totalInstructors;
    }

    // Getters dan Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public long getTotalInstructors() { return totalInstructors; }
    public void setTotalInstructors(long totalInstructors) { this.totalInstructors = totalInstructors; }
}