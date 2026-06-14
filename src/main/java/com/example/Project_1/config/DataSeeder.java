package com.example.Project_1.config;

import com.example.Project_1.model.Role;
import com.example.Project_1.model.User;
import com.example.Project_1.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminEmail = "admin@admin.com";
            
            if (userRepository.findByEmail(adminEmail).isEmpty()) {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode("pwd12345"));
                admin.setRole(Role.ADMIN);
                userRepository.save(admin);
                
                System.out.println("Admin account created successfully!");
            } else {
                System.out.println("Admin account already exists. Skipping creation.");
            }
        };
    }
}