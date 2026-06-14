package com.example.Project_1.controller;

import com.example.Project_1.model.Booking;
import com.example.Project_1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/bookings")
@CrossOrigin(
    origins = {
        "http://localhost:5173",
        "http://127.0.0.1:5173",
        "http://localhost:5174",
        "http://127.0.0.1:5174"
    }
)
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/user/{email}")
    public List<Booking> getUserBookings(@PathVariable String email) {
        return bookingService.getUserBookings(email);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        return bookingService.getBookingSummary();
    }

    @GetMapping("/report/events")
    public Map<String, Long> getBookingsPerEvent() {
        return bookingService.getBookingsPerEvent();
    }
}