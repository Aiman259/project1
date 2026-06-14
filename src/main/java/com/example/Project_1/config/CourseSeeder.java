package com.example.Project_1.config;

import com.example.Project_1.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseSeeder {

    @Bean
    CommandLineRunner initDatabase(CourseRepository repository) {
        return args -> {

            System.out.println("Course Seeder Disabled");
            System.out.println("Using existing MongoDB data");

        };
    }
}

