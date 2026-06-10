package com.example.Project_1.repository;

import com.example.Project_1.model.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {
    Page<Instructor> findAll(Pageable pageable);
    Page<Instructor> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Instructor> findBySpecialization(String specialization, Pageable pageable);
}