package com.example.Project_1.controller;

import com.example.Project_1.model.Course;
import com.example.Project_1.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/courses")
public class CourseController {


private final CourseRepository repository;

public CourseController(CourseRepository repository) {
    this.repository = repository;
}

@GetMapping
public ResponseEntity<Page<Course>> getAllCourses(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5 ") int size) {

    Pageable paging = PageRequest.of(page, size);
    return ResponseEntity.ok(repository.findAll(paging));
}

@GetMapping("/{id}")
public ResponseEntity<Course> getCourseById(@PathVariable String id) {

    Optional<Course> course = repository.findById(id);

    return course.map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PostMapping
public Course createCourse(@RequestBody Course course) {
    return repository.save(course);
}

@PutMapping("/{id}")
public ResponseEntity<Course> updateCourse(
        @PathVariable String id,
        @RequestBody Course updatedCourse) {

    return repository.findById(id)
            .map(course -> {

                course.setTitle(updatedCourse.getTitle());
                course.setDescription(updatedCourse.getDescription());
                course.setCategory(updatedCourse.getCategory());
                course.setVenue(updatedCourse.getVenue());
                course.setEventDate(updatedCourse.getEventDate());
                course.setPrice(updatedCourse.getPrice());
                course.setCapacity(updatedCourse.getCapacity());
                course.setSeatsAvailable(updatedCourse.getSeatsAvailable());
                course.setStatus(updatedCourse.getStatus());

                return ResponseEntity.ok(repository.save(course));
            })
            .orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCourse(@PathVariable String id) {

    if (!repository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
}


}
