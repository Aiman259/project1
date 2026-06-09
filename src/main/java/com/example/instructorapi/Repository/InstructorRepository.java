package com.example.instructorapi.repository;

import com.example.instructorapi.model.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {
    
    // Method untuk carian berdasarkan nama
    Page<Instructor> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
    // Method untuk carian berdasarkan pengkhususan
    Page<Instructor> findBySpecialization(String specialization, Pageable pageable);
}