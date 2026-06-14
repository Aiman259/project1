package com.example.Project_1.service;

import com.example.Project_1.model.Booking;
import com.example.Project_1.model.Course;
import com.example.Project_1.repository.BookingRepository;
import com.example.Project_1.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Booking createBooking(Booking booking) {

        System.out.println("BOOKING SERVICE NEW VERSION");

        Course course = courseRepository
                .findById(booking.getEventId())
                .orElseThrow(() ->
                        new RuntimeException("Event not found!")
                );

        System.out.println("EVENT: " + course.getTitle());
        System.out.println("STATUS: " + course.getStatus());
        System.out.println("DATE: " + course.getEventDate());

        if (!"ACTIVE".equalsIgnoreCase(course.getStatus())) {
            throw new RuntimeException(
                    "Event is inactive!"
            );
        }

        LocalDate eventDate =
                LocalDate.parse(course.getEventDate());

        if (eventDate.isBefore(LocalDate.now())) {
            throw new RuntimeException(
                    "Cannot book past event!"
            );
        }

        if (course.getSeatsAvailable() <= 0) {
            throw new RuntimeException(
                    "No seats available!"
            );
        }

        course.setSeatsAvailable(
                course.getSeatsAvailable() - 1
        );

        courseRepository.save(course);

        booking.setBookingDate(
                LocalDateTime.now(
                        ZoneId.of("Asia/Kuala_Lumpur")
                )
        );

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getUserBookings(String email) {
        return bookingRepository.findByUserEmail(email);
    }

    public void deleteBooking(String id) {

        Booking booking = bookingRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Booking not found!"
                        )
                );

        Course course = courseRepository
                .findById(booking.getEventId())
                .orElse(null);

        if (course != null) {

            course.setSeatsAvailable(
                    course.getSeatsAvailable() + 1
            );

            courseRepository.save(course);
        }

        bookingRepository.deleteById(id);
    }

    public Map<String, Object> getBookingSummary() {

    List<Booking> bookings =
            bookingRepository.findAll();

    double totalRevenue = 0;

    for (Booking booking : bookings) {

        Course course = courseRepository
                .findById(booking.getEventId())
                .orElse(null);

        if (course != null) {

            totalRevenue += course.getPrice();

        }
    }

    Map<String, Object> summary =
            new HashMap<>();

    summary.put(
            "totalBookings",
            bookings.size()
    );

    summary.put(
            "totalRevenue",
            totalRevenue
    );

    return summary;
}

    public Map<String, Long> getBookingsPerEvent() {

        Aggregation aggregation = Aggregation.newAggregation(

                Aggregation.group("eventTitle")
                        .count()
                        .as("totalBookings"),

                Aggregation.sort(
                        org.springframework.data.domain.Sort.Direction.DESC,
                        "totalBookings"
                )

        );

        AggregationResults<Map> results =
                mongoTemplate.aggregate(
                        aggregation,
                        "bookings",
                        Map.class
                );

        Map<String, Long> report =
                new LinkedHashMap<>();

        for (Map result : results.getMappedResults()) {

            String eventTitle =
                    (String) result.get("_id");

            Number totalBookings =
                    (Number) result.get("totalBookings");

            report.put(
                    eventTitle,
                    totalBookings.longValue()
            );
        }

        return report;
    }
}