package com.example.instructorapi.service;

import com.example.instructorapi.dto.InstructorSpecializationSummary;
import com.example.instructorapi.dto.InstructorStatusSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorReportService {

    @Autowired
    private MongoTemplate mongoTemplate;

public List<InstructorStatusSummary> getInstructorStatusSummary() {
    Aggregation aggregation = Aggregation.newAggregation(
        // 1. Tapis data yang status-nya null (pastikan wujud dan bukan null)
        Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("status").ne(null)),
        
        // 2. Group berdasarkan status
        Aggregation.group("status").count().as("totalInstructors"),
        
        // 3. Project supaya _id dipetakan ke status
        Aggregation.project("totalInstructors")
            .and("_id").as("status"),
            
        Aggregation.sort(Sort.Direction.DESC, "totalInstructors")
    );

    AggregationResults<InstructorStatusSummary> results = 
        mongoTemplate.aggregate(aggregation, "instructors", InstructorStatusSummary.class);

    return results.getMappedResults();
}
public List<InstructorSpecializationSummary> getSpecializationSummary() {
    Aggregation aggregation = Aggregation.newAggregation(
        Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("specialization").ne(null)),
        Aggregation.group("specialization").count().as("totalInstructors"),
        Aggregation.project("totalInstructors")
            .and("_id").as("specialization"),
        Aggregation.sort(Sort.Direction.DESC, "totalInstructors")
    );

    AggregationResults<InstructorSpecializationSummary> results = 
        mongoTemplate.aggregate(aggregation, "instructors", InstructorSpecializationSummary.class);

    return results.getMappedResults();
}
}