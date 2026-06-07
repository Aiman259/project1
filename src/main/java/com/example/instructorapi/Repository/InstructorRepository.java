package com.example.instructorapi.Repository;

import com.example.instructorapi.model.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // WAJIB TAMBAH INI
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {

    // Untuk search nama
    List<Instructor> findByNameContainingIgnoreCase(String keyword);

    // Untuk filter specialization (tanpa pagination - kalau perlu)
    List<Instructor> findBySpecialization(String specialization);

    // Untuk filter specialization + pagination (DENGAN pageable)
    Page<Instructor> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Instructor> findBySpecialization(String specialization, Pageable pageable);
    }

