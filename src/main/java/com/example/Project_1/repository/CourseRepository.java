package com.example.Project_1.repository;

import com.example.Project_1.model.Course;// Tambah import ini
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CourseRepository extends MongoRepository<Course, String> {
}