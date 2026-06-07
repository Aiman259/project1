package com.example.instructorapi.service;

import com.example.instructorapi.model.Instructor;
import com.example.instructorapi.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository repository;

    public List<Instructor> getAll() {
        return repository.findAll();
    }

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