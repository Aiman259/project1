package com.example.instructorapi.service;

import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository repository; // <-- BETULKAN: guna huruf besar 'R'

    // Method untuk menyokong API v1 (Pagination)
    public Page<Instructor> getAll(String keyword, String specialization, int page, int size, String[] sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort[1].equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sort[0]));

        if (keyword != null && !keyword.isEmpty()) {
            return repository.findByNameContainingIgnoreCase(keyword, pageable);
        } else if (specialization != null && !specialization.isEmpty()) {
            return repository.findBySpecialization(specialization, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    // Method untuk menyokong API v2 (Get All)
    public List<Instructor> findAll() {
        return repository.findAll();
    }

    public Instructor getById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    public Instructor create(Instructor instructor) {
        return repository.save(instructor);
    }

    public Instructor update(String id, Instructor instructor) {
        Instructor existing = getById(id);
        existing.setName(instructor.getName());
        existing.setSpecialization(instructor.getSpecialization());
        existing.setStatus(instructor.getStatus());
        existing.setYearsOfExperience(instructor.getYearsOfExperience());
        return repository.save(existing);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}