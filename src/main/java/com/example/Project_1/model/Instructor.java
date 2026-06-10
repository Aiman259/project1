package com.example.Project_1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructors")
public class Instructor {
    @Id
    private String id;
    
    @Indexed // Exercise 7: Menambah index untuk kelajuan carian
    private String name;
    
    private String specialization;
    private boolean active;
    private int yearsExperience;

    public Instructor() {}

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public int getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }
}