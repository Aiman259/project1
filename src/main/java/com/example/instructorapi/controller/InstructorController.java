package com.example.instructorapi.controller;

import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService service;

    // Endpoint: GET /api/instructors
    // Contoh:
    // /api/instructors?keyword=Ahmad&specialization=Backend&page=0&size=5&sort=name,asc
    @GetMapping
    public Page<Instructor> getAll(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String specialization,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {

        return service.getAll(keyword, specialization, page, size, sort);
    }

    // Endpoint: GET /api/instructors/{id}
    @GetMapping("/{id}")
    public Instructor getById(@PathVariable String id) {
        return service.getById(id);
    }

    // Endpoint: POST /api/instructors
    @PostMapping
    public Instructor create(@RequestBody Instructor instructor) {
        return service.create(instructor);
    }

    // Endpoint: PUT /api/instructors/{id}
    @PutMapping("/{id}")
    public Instructor update(@PathVariable String id, @RequestBody Instructor instructor) {
        return service.update(id, instructor);
    }

    // Endpoint: DELETE /api/instructors/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}