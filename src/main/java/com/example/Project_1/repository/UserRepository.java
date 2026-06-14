package com.example.Project_1.repository;

import com.example.Project_1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional; // Pastikan import ini ada

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsByEmail(String email); 
    Optional<User> findByEmail(String email); 
}