package com.example.instructorapi.model;

public class Instructor {
    private String id; // Kita tambah ID untuk senang bezakan instructor nanti
    private String name;
    private String email;
    private String specialization;
    private int yearsExperience;

    // 1. Constructor Kosong (No-args constructor)
    public Instructor() {
    }

    // 2. Constructor Berparameter (All-args constructor)
    public Instructor(String id, String name, String email, String specialization, int yearsExperience) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.yearsExperience = yearsExperience;
    }

    // 3. Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }
}