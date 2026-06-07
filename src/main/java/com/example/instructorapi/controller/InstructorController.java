package com.example.instructorapi.controller;

import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    @Autowired
    private InstructorService service;

    @GetMapping
    public List<Instructor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Instructor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Instructor create(@RequestBody Instructor instructor) {
        return service.create(instructor);
    }

    @PutMapping("/{id}")
    public Instructor update(@PathVariable String id, @RequestBody Instructor instructor) {
        return service.update(id, instructor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}