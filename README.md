# Project 1

# Event Booking System

## Project Overview

Event Booking System is a full-stack web application developed using React, Spring Boot, MongoDB, JWT Authentication, and Docker.

The system allows users to browse available events, view event details, make bookings, and manage their reservations online. Administrators can manage events, monitor bookings, and generate booking reports through a secure dashboard.

---

## Login Page

[Insert Login Page Screenshot]

---

## Register Page

[Insert Register Page Screenshot]

---

## Admin Features

### Admin Dashboard

[Insert Dashboard Screenshot]

### Event Management

[Insert Event Management Screenshot]

### Create Event

[Insert Create Event Screenshot]

### Edit Event

[Insert Edit Event Screenshot]

### Revenue Report

[Insert Revenue Report Screenshot]

---

## User Features

### Event Listing

[Insert Event Listing Screenshot]

### Event Details

[Insert Event Details Screenshot]

### My Bookings

[Insert My Bookings Screenshot]

### Booking Confirmation

[Insert Booking Screenshot]

---

## Problem Statement

Many small event organizers still manage registrations manually using spreadsheets and messaging applications. This process is inefficient, difficult to track, and prone to human error.

This project provides a centralized web-based solution for event management and online booking.

---

## Project Objectives

* Develop a full-stack web application using React and Spring Boot.
* Implement JWT-based authentication and authorization.
* Manage event and booking information using MongoDB.
* Provide booking and reporting functionality for administrators.
* Apply business rules and validation for booking management.

---

## Technology Stack

### Frontend

* React.js
* React Router DOM
* Tailwind CSS

### Backend

* Spring Boot
* Spring Security
* JWT Authentication

### Database

* MongoDB

### Deployment

* Docker
* Docker Compose

---

## User Roles

### Admin

* Create events
* Edit events
* Delete events
* View all bookings
* View dashboard reports
* Monitor revenue information

### User

* Register account
* Login securely
* Browse available events
* View event details
* Book events
* View personal bookings
* Cancel bookings

---

## Main Features

### Authentication

* User Registration
* User Login
* JWT Authentication
* Role-Based Access Control

### Event Management

* Create Event
* Edit Event
* Delete Event
* Search Event
* Sort Event
* View Event Details

### Booking Management

* Book Event
* View My Bookings
* Cancel Booking
* Automatic Seat Updates

### Reporting

* Total Bookings
* Total Revenue
* Bookings Per Event Report

---

## Business Rules

* Email must be unique.
* Users cannot book inactive events.
* Users cannot book sold-out events.
* Users cannot book past events.
* Seats are automatically reduced after booking.
* Seats are automatically restored after cancellation.
* Revenue is calculated based on event bookings.

---

## MongoDB Collections

### Users Collection

```json
{
  "id": "...",
  "fullName": "Aiman Firdaus",
  "email": "aiman@gmail.com",
  "password": "encrypted-password",
  "role": "USER",
  "createdAt": "2026-06-14"
}
```

### Events Collection

```json
{
  "id": "...",
  "title": "Tech Innovation Summit",
  "category": "Technology",
  "venue": "KLCC",
  "eventDate": "2026-09-10",
  "price": 120,
  "capacity": 500,
  "seatsAvailable": 450,
  "status": "ACTIVE"
}
```

### Bookings Collection

```json
{
  "id": "...",
  "userEmail": "aiman@gmail.com",
  "eventId": "...",
  "eventTitle": "Tech Innovation Summit",
  "bookingDate": "2026-06-14"
}
```

---

## API Endpoints

### Authentication

POST /api/auth/register

POST /api/auth/login

### Events

GET /api/v1/courses

GET /api/v1/courses/{id}

POST /api/v1/courses

PUT /api/v1/courses/{id}

DELETE /api/v1/courses/{id}

### Bookings

POST /api/v1/bookings

GET /api/v1/bookings

GET /api/v1/bookings/user/{email}

DELETE /api/v1/bookings/{id}

### Reports

GET /api/v1/bookings/summary

GET /api/v1/bookings/report/events

---

## Setup Instructions

### Start Docker Containers

```bash
docker compose up --build -d
```

### Access Application

**Frontend**
http://localhost:5173

**Backend**
http://localhost:8081

**MongoDB**
mongodb://localhost:27017

---

## Aggregation / Reporting Feature

Implemented MongoDB reporting features:

* Total Bookings
* Total Revenue
* Bookings Per Event

These reports help administrators analyze event performance and booking activity.

---

## Challenges Faced

* Integrating React frontend with Spring Boot backend.
* Implementing JWT authentication and authorization.
* Managing seat availability after booking and cancellation.
* Implementing event validation rules.
* Building dashboard reporting features.

---

## Future Improvements

* Event image upload
* Dashboard charts
* Advanced event filtering
* CSV export functionality
* Mobile responsive enhancements

---

## Developer

**Aiman Firdaus**

Capstone Project 2026

**Event Booking System**
