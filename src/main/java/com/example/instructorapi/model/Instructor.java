package com.example.instructorapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructors")
public class Instructor {
    @Id
    private String id;
    private String name;
    private String email;
    private String specialization;

    // TAMBAH DUA FIELD INI:
    private String status; 
    private int yearsOfExperience;

    // Getter & Setter untuk id, name, email, specialization...
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    // TAMBAH Getter & Setter untuk status dan yearsOfExperience:
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
}