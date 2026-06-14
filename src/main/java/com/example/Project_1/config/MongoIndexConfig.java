package com.example.Project_1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;

@Configuration
public class MongoIndexConfig {

    private static final Logger logger = LoggerFactory.getLogger(MongoIndexConfig.class);

    @Bean
    public ApplicationRunner createCourseIndexes(MongoTemplate mongoTemplate) {
        return args -> {
            IndexOperations indexOperations = mongoTemplate.indexOps("courses");

            // Indeks tunggal
            indexOperations.ensureIndex(new Index().on("category", Sort.Direction.ASC).named("idx_courses_category"));
            indexOperations.ensureIndex(new Index().on("published", Sort.Direction.ASC).named("idx_courses_published"));

            // Indeks komposit
            indexOperations.ensureIndex(new Index()
                            .on("category", Sort.Direction.ASC)
                            .on("published", Sort.Direction.ASC)
                            .named("idx_courses_category_published"));

            logger.info("MongoDB indexes checked or created for courses collection");
        };
    }
}