package com.example.Project_1.service;

import com.example.Project_1.dto.CreateInstructorRequest;
import com.example.Project_1.model.Instructor;
import com.example.Project_1.repository.InstructorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    private static final Logger logger = LoggerFactory.getLogger(InstructorService.class);

    @Autowired
    private InstructorRepository repository;

    public Page<Instructor> getAllInstructors(Pageable pageable) {
        logger.info("Fetching all instructors: Page={}, Size={}, Sort={}", 
                    pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return repository.findAll(pageable);
    }

    public Page<Instructor> searchInstructors(String keyword, Pageable pageable) {
        logger.info("Search: '{}', Page={}, Size={}, Sort={}", 
                    keyword, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return repository.findByNameContainingIgnoreCase(keyword, pageable);
    }

    public Page<Instructor> getInstructorsBySpecialization(String specialization, Pageable pageable) {
        logger.info("Filter: '{}', Page={}, Size={}, Sort={}", 
                    specialization, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return repository.findBySpecialization(specialization, pageable);
    }

    public Instructor getInstructorById(String id) { return repository.findById(id).orElse(null); }

    public Instructor saveInstructor(CreateInstructorRequest req) {
        Instructor i = new Instructor();
        i.setName(req.getName()); i.setSpecialization(req.getSpecialization());
        i.setYearsExperience(req.getYearsExperience()); i.setActive(true);
        return repository.save(i);
    }

    public Instructor updateInstructor(String id, CreateInstructorRequest req) {
        Instructor i = repository.findById(id).orElse(null);
        if (i != null) {
            i.setName(req.getName()); i.setSpecialization(req.getSpecialization());
            i.setYearsExperience(req.getYearsExperience());
            return repository.save(i);
        }
        return null;
    }

    public void deleteInstructor(String id) { repository.deleteById(id); }
}