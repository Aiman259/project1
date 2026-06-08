package com.example.instructorapi.controller;

import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @GetMapping
    public Page<Instructor> getAll(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String specialization,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {

        return service.getAll(keyword, specialization, page, size, sort);
    }

    // Fungsi tunggal untuk getById
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody Instructor instructor) {
        return ResponseEntity.ok(service.create(instructor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable String id, @RequestBody Instructor instructor) {
        return ResponseEntity.ok(service.update(id, instructor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

