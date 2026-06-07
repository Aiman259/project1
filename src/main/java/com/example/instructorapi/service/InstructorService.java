package com.example.instructorapi.service;

import com.example.instructorapi.dto.CreateInstructorRequest;
import com.example.instructorapi.model.Instructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InstructorService {

    private final List<Instructor> instructors = new ArrayList<>();

    // 2 Sample instructors at startup (Keperluan Sukses GET)
    public InstructorService() {
        instructors.add(new Instructor("1", "Ahmad Fauzi", "fauzi@gmail.com", "Electrical Engineering", 5));
        instructors.add(new Instructor("2", "Siti Aminah", "aminah@academic.com", "Web Development", 3));
    }

    // Ambil semua data
    public List<Instructor> getAllInstructors() {
        return instructors;
    }

    // Method baru untuk POST: Tambah instructor ke dalam list
    public Instructor addInstructor(CreateInstructorRequest request) {
        // Guna UUID untuk generate ID rawak yang unik supaya tak bertembung
        String generatedId = UUID.randomUUID().toString();

        // Map DTO data ke Model Instructor
        Instructor newInstructor = new Instructor(
                generatedId,
                request.getName(),
                request.getEmail(),
                request.getSpecialization(),
                request.getYearsExperience());

        // Simpan dalam memori list
        instructors.add(newInstructor);

        // Pulangkan balik data yang berjaya dicipta
        return newInstructor;
    }
}