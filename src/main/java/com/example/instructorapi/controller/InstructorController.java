package com.example.instructorapi.controller;

import com.example.instructorapi.dto.CreateInstructorRequest;
import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.service.InstructorService;
import jakarta.validation.Valid; // Pastikan import yang ni
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    // Tambah @Valid kat sini!
    @PostMapping
    public Instructor createInstructor(@Valid @RequestBody CreateInstructorRequest request) {
        return instructorService.addInstructor(request);
    }
}