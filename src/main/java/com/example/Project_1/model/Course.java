package com.example.Project_1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {

@Id
private String id;

private String title;
private String description;
private String category;
private String venue;
private String eventDate;
private double price;
private int capacity;
private int seatsAvailable;
private String status;

public Course() {
}

public Course(String title, String description, String category,
              String venue, String eventDate,
              double price, int capacity,
              int seatsAvailable, String status) {

    this.title = title;
    this.description = description;
    this.category = category;
    this.venue = venue;
    this.eventDate = eventDate;
    this.price = price;
    this.capacity = capacity;
    this.seatsAvailable = seatsAvailable;
    this.status = status;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public String getVenue() {
    return venue;
}

public void setVenue(String venue) {
    this.venue = venue;
}

public String getEventDate() {
    return eventDate;
}

public void setEventDate(String eventDate) {
    this.eventDate = eventDate;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}

public int getCapacity() {
    return capacity;
}

public void setCapacity(int capacity) {
    this.capacity = capacity;
}

public int getSeatsAvailable() {
    return seatsAvailable;
}

public void setSeatsAvailable(int seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

}
