package com.example.Project_1.repository;

import com.example.Project_1.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking> findByUserEmail(String userEmail);

}