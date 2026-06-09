package com.example.instructorapi.controller;

import com.example.instructorapi.dto.InstructorSpecializationSummary;
import com.example.instructorapi.dto.InstructorStatusSummary;
import com.example.instructorapi.service.InstructorReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports/instructors")
public class InstructorReportController {

    @Autowired
    private InstructorReportService reportService;

    @GetMapping("/by-status")
    public List<InstructorStatusSummary> getByStatus() {
        return reportService.getInstructorStatusSummary();
    }
    @GetMapping("/by-specialization")
public List<InstructorSpecializationSummary> getBySpecialization() {
    return reportService.getSpecializationSummary();
}
}