package com.example.Project_1.controller;

import com.example.Project_1.dto.CreateInstructorRequest;
import com.example.Project_1.model.Instructor;
import com.example.Project_1.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructors")
public class ControllerInstructor { 
    private final InstructorService service; 
    public ControllerInstructor(InstructorService service) { this.service = service; } 

    @GetMapping("/search")
    public Page<Instructor> search(@RequestParam String keyword, @PageableDefault(size=5) Pageable p) {
        return service.searchInstructors(keyword, p);
    }

    @GetMapping
    public Page<Instructor> getAll(@RequestParam(required = false) String specialization, @PageableDefault(size=5) Pageable p) {
        if (specialization != null) return service.getInstructorsBySpecialization(specialization, p);
        return service.getAllInstructors(p);
    } 

    @GetMapping("/{id}") public Instructor getById(@PathVariable String id) { return service.getInstructorById(id); } 
    @PostMapping public Instructor create(@Valid @RequestBody CreateInstructorRequest req) { return service.saveInstructor(req); } 
    @PutMapping("/{id}") public Instructor update(@PathVariable String id, @Valid @RequestBody CreateInstructorRequest req) { return service.updateInstructor(id, req); } 
    @DeleteMapping("/{id}") public String delete(@PathVariable String id) { service.deleteInstructor(id); return "Deleted ID: " + id; }
}