package com.example.Project_1.repository;

import com.example.Project_1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Kita boleh menambah method carian mengikut email contohnya:
    User findByEmail(String email);
}