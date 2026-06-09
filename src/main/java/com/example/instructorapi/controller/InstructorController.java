package com.example.instructorapi.controller;

import com.example.instructorapi.dto.InstructorV2DTO;
import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorService service;

    // --- API V1 ---
    @GetMapping("/v1/instructors")
    public Page<Instructor> getAllV1(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String specialization,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return service.getAll(keyword, specialization, page, size, sort);
    }

    // --- API V2 ---
    @GetMapping("/v2/instructors")
    public List<InstructorV2DTO> getAllInstructorsV2() {
        return service.findAll().stream()
            .map(inst -> new InstructorV2DTO(
                inst.getId(),
                inst.getName(),
                inst.getSpecialization(),
                inst.getStatus(),
                inst.getYearsOfExperience()
            ))
            .collect(Collectors.toList());
    }

    // CRUD Methods
    @GetMapping("/v1/instructors/{id}")
    public ResponseEntity<Instructor> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/v1/instructors")
    public ResponseEntity<Instructor> create(@RequestBody Instructor instructor) {
        return ResponseEntity.ok(service.create(instructor));
    }

    @PutMapping("/v1/instructors/{id}")
    public ResponseEntity<Instructor> update(@PathVariable String id, @RequestBody Instructor instructor) {
        return ResponseEntity.ok(service.update(id, instructor));
    }

    @DeleteMapping("/v1/instructors/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}