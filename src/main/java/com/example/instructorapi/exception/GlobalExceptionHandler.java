package com.example.instructorapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> details = new HashMap<>();

        // Ekstrak semua error mesej yang kita set dekat DTO tadi
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            details.put(fieldName, errorMessage);
        });

        // Ikut format tepat yang diminta dalam assignment
        response.put("error", "Validation failed");
        response.put("details", details);

        // Pulangkan status HTTP 400 Bad Request bersama JSON kustom kita
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}