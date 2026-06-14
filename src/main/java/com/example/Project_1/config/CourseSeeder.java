package com.example.Project_1.config;

import com.example.Project_1.model.Course;
import com.example.Project_1.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseSeeder {

@Bean
CommandLineRunner initDatabase(CourseRepository repository) {
    return args -> {

        repository.deleteAll();

        repository.saveAll(List.of(

            new Course(
                    "Java Spring Boot Workshop",
                    "Learn Spring Boot from beginner to intermediate.",
                    "Programming",
                    "UTHM Batu Pahat",
                    "2026-07-01",
                    99.00,
                    50,
                    50,
                    "ACTIVE"
            ),

            new Course(
                    "React Frontend Bootcamp",
                    "Build modern web apps using React.",
                    "Frontend",
                    "Online",
                    "2026-07-10",
                    79.00,
                    40,
                    40,
                    "ACTIVE"
            ),

            new Course(
                    "MongoDB Essentials",
                    "Learn MongoDB fundamentals.",
                    "Database",
                    "Online",
                    "2026-07-15",
                    59.00,
                    30,
                    30,
                    "ACTIVE"
            ),

            new Course(
                    "Cloud Architecture",
                    "Introduction to cloud computing.",
                    "Cloud",
                    "Kuala Lumpur",
                    "2026-08-01",
                    129.00,
                    60,
                    60,
                    "ACTIVE"
            )

        ));

        System.out.println("Event data loaded successfully!");
    };
}

}
