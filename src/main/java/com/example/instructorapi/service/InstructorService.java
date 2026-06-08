package com.example.instructorapi.service;

import com.example.instructorapi.repository.InstructorRepository;
import com.example.instructorapi.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@Service
public class InstructorService {

    // 1. Initialize Logger
    private static final Logger logger = LoggerFactory.getLogger(InstructorService.class);

    @Autowired
    private InstructorRepository repository;

    public Page<Instructor> getAll(String keyword, String specialization, int page, int size, String[] sort) {

        // 2. Log incoming request parameters
        logger.info("Received request: keyword={}, specialization={}, page={}, size={}, sort={}",
                keyword, specialization, page, size, Arrays.toString(sort));

        Pageable pageable = createPageable(page, size, sort);

        if (keyword != null && !keyword.isEmpty()) {
            logger.info("Searching by keyword: {}", keyword);
            return repository.findByNameContainingIgnoreCase(keyword, pageable);
        } else if (specialization != null && !specialization.isEmpty()) {
            logger.info("Filtering by specialization: {}", specialization);
            return repository.findBySpecialization(specialization, pageable);
        }

        logger.info("Displaying all data (no search/filter applied)");
        return repository.findAll(pageable);
    }

    private Pageable createPageable(int page, int size, String[] sort) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sort != null) {
            for (String s : sort) {
                String[] parts = s.split(",");
                Sort.Direction dir = (parts.length > 1 && parts[1].equalsIgnoreCase("desc"))
                        ? Sort.Direction.DESC
                        : Sort.Direction.ASC;
                orders.add(new Sort.Order(dir, parts[0]));
            }
        }
        return PageRequest.of(page, size, Sort.by(orders));
    }

    // CRUD Methods
    public Instructor getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Instructor create(Instructor instructor) {
        return repository.save(instructor);
    }

    public Instructor update(String id, Instructor instructor) {
        instructor.setId(id);
        return repository.save(instructor);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}