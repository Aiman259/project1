# Project 1

# Event Booking System

## Project Overview

Event Booking System is a full-stack web application developed using React, Spring Boot, MongoDB, JWT Authentication, and Docker.

The system allows users to browse available events, view event details, make bookings, and manage their reservations online. Administrators can manage events, monitor bookings, and generate booking reports through a secure dashboard.

---

## Login Page

<img width="1706" height="981" alt="image" src="https://github.com/user-attachments/assets/9136aef6-79dc-4ccd-b7d5-45f5e4bf6cc2" />

---

## Register Page

<img width="1706" height="981" alt="image" src="https://github.com/user-attachments/assets/8e159e44-f6ef-4647-b43d-54b2496df760" />

---

## Admin Features

### Admin Dashboard

<img width="1706" height="987" alt="image" src="https://github.com/user-attachments/assets/d444e257-b442-4d72-8045-c96d3047e0b3" />


### Event

<img width="1185" height="941" alt="image" src="https://github.com/user-attachments/assets/ea257020-368d-42db-83fb-a5763b86c954" />
<img width="1704" height="930" alt="image" src="https://github.com/user-attachments/assets/f44a6819-fdda-4892-a5d4-b2b10ac5e1f2" />
<img width="1706" height="938" alt="image" src="https://github.com/user-attachments/assets/1ebd21e5-51ec-4e94-add2-cb1bd0a4e190" />

### Create Event

<img width="1706" height="938" alt="image" src="https://github.com/user-attachments/assets/0df96724-bcc3-431b-abe1-7a74cbadcb65" />
<img width="1700" height="933" alt="image" src="https://github.com/user-attachments/assets/99545b15-5ee4-4f34-88ed-4ed40ac948d6" />


### Edit Event

<img width="1706" height="918" alt="image" src="https://github.com/user-attachments/assets/24854983-be54-4d73-a47b-6d03c7207f0e" />
<img width="1698" height="949" alt="image" src="https://github.com/user-attachments/assets/54b207d5-e1d6-4c6c-8b5c-c89586bbb3da" />

### Event Details

<img width="1706" height="937" alt="image" src="https://github.com/user-attachments/assets/ac6718ec-3149-485b-9b2f-469b03143f55" />


### Home

<img width="1704" height="934" alt="image" src="https://github.com/user-attachments/assets/f00fd556-74ec-452b-830a-30abf301974d" />


---

## User Features

### Event Listing

<img width="1702" height="935" alt="image" src="https://github.com/user-attachments/assets/32aee0a4-59a1-45f5-b8cd-ce3500a6e9b7" />

<img width="1706" height="954" alt="image" src="https://github.com/user-attachments/assets/127a08a9-efbc-409b-896f-dc3dc468ed2b" />

<img width="1706" height="935" alt="image" src="https://github.com/user-attachments/assets/c0a9757d-96fb-4ad6-b682-499e355ecf1e" />

### Event Details


<img width="1706" height="940" alt="image" src="https://github.com/user-attachments/assets/922e8f26-6ce7-489e-a1d0-7d61248221ab" />

### My BooKings

<img width="1706" height="938" alt="image" src="https://github.com/user-attachments/assets/321ede7f-74c9-4d95-912b-dfccbff4ff0d" />


### Home

<img width="1706" height="935" alt="image" src="https://github.com/user-attachments/assets/e6e83509-acda-497f-a605-03f1b2cff748" />


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

## Reporting Feature

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
