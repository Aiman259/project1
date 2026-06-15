# API Documentation

# Event Booking System

## Base URL

```text
http://localhost:8081
```

---

# Authentication APIs

## Register User

### Endpoint

```http
POST /api/auth/register
```

### Request Body

```json
{
  "fullName": "Zul",
  "email": "Zul@gmail.com",
  "password": "123",
  "role": "ADMIN"
}
```

### Success Response

```text
User registered successfully!
```

---

## Login User

### Endpoint

```http
POST /api/auth/login
```

### Request Body

```json
{
  "email": "Zul@gmail.com",
  "password": "123"
}
```

### Success Response

```json
{
  "role": "ADMIN",
  "email": "Zul@gmail.com",
  "token": "JWT_TOKEN"
}
```

---

# Event APIs

## Get All Events

### Endpoint

```http
GET /api/v1/courses
```

### Description

Retrieve all available events with pagination support.

### Sample Response

```json
{
  "content": [
    {
      "id": "6a2fd4c192511d8f837b13eb",
      "title": "Food & Music Carnival",
      "description": "Enjoy live music performances, food trucks and family-friendly activities.",
      "category": "Entertainment",
      "venue": "Batu Pahat Stadium",
      "eventDate": "2026-07-30",
      "price": 20.0,
      "capacity": 800,
      "seatsAvailable": 793,
      "status": "ACTIVE"
    }
  ]
}
```

---

## Get Event By ID

### Endpoint

```http
GET /api/v1/courses/6a2fd4c192511d8f837b13eb
```

### Sample Response

```json
{
  "id": "6a2fd4c192511d8f837b13eb",
  "title": "Food & Music Carnival",
  "description": "Enjoy live music performances, food trucks and family-friendly activities.",
  "category": "Entertainment",
  "venue": "Batu Pahat Stadium",
  "eventDate": "2026-07-30",
  "price": 20.0,
  "capacity": 800,
  "seatsAvailable": 793,
  "status": "ACTIVE"
}
```

---

## Create Event (Admin Only)

### Endpoint

```http
POST /api/v1/courses
```

### Request Body

```json
{
  "title": "UTHM Cultural Festival 2026",
  "description": "Annual cultural festival featuring traditional performances, food stalls and exhibitions.",
  "category": "Festival",
  "venue": "UTHM Main Hall",
  "eventDate": "2026-09-20",
  "price": 15,
  "capacity": 500,
  "seatsAvailable": 500,
  "status": "ACTIVE"
}
```

### Sample Response

```json
{
  "id": "6a2fd50560198964d1ffaacd",
  "title": "UTHM Cultural Festival 2026",
  "description": "Annual cultural festival featuring traditional performances, food stalls and exhibitions.",
  "category": "Festival",
  "venue": "UTHM Main Hall",
  "eventDate": "2026-09-20",
  "price": 15.0,
  "capacity": 500,
  "seatsAvailable": 500,
  "status": "ACTIVE"
}
```

---

## Update Event (Admin Only)

### Endpoint

```http
PUT /api/v1/courses/6a2fd50560198964d1ffaacd
```

### Request Body

```json
{
  "title": "UTHM Cultural Festival 2026 Updated",
  "description": "Updated cultural festival information.",
  "category": "Festival",
  "venue": "UTHM Main Hall",
  "eventDate": "2026-09-25",
  "price": 30,
  "capacity": 600,
  "seatsAvailable": 600,
  "status": "ACTIVE"
}
```

### Sample Response

```json
{
  "id": "6a2fd50560198964d1ffaacd",
  "title": "UTHM Cultural Festival 2026 Updated",
  "description": "Updated cultural festival information.",
  "category": "Festival",
  "venue": "UTHM Main Hall",
  "eventDate": "2026-09-25",
  "price": 30,
  "capacity": 600,
  "seatsAvailable": 600,
  "status": "ACTIVE"
}
```

---

## Delete Event (Admin Only)

### Endpoint

```http
DELETE /api/v1/courses/6a2fd50560198964d1ffaacd
```

### Sample Response

```text
Course deleted successfully
```

---

# Booking APIs

## Create Booking

### Endpoint

```http
POST /api/v1/bookings
```

### Request Body

```json
{
  "userEmail": "Ali@gmail.com",
  "eventId": "6a2fd4e292511d8f837b13f1"
}
```

### Sample Response

```json
{
  "id": "6a2ffdb660198964d1ffaad7",
  "userEmail": "Ali@gmail.com",
  "eventId": "6a2fd4e292511d8f837b13f1",
  "eventTitle": "Health & Wellness Expo",
  "bookingDate": "2026-06-15T21:27:18.923"
}
```

---

## Get All Bookings

### Endpoint

```http
GET /api/v1/bookings
```

### Sample Response

```json
[
  {
    "id": "6a2fdcb060198964d1ffaad0",
    "userEmail": "Amin@gmail.com",
    "eventId": "6a2fd4c192511d8f837b13eb",
    "eventTitle": "Food & Music Carnival",
    "bookingDate": "2026-06-15T19:06:24.368"
  }
]
```

---

## Get User Bookings

### Endpoint

```http
GET /api/v1/bookings/user/Amin@gmail.com
```

### Sample Response

```json
[
  {
    "id": "6a2fdcb060198964d1ffaad0",
    "userEmail": "Amin@gmail.com",
    "eventId": "6a2fd4c192511d8f837b13eb",
    "eventTitle": "Food & Music Carnival",
    "bookingDate": "2026-06-15T19:06:24.368"
  }
]
```

---

## Delete Booking (Admin Only)

### Endpoint

```http
DELETE /api/v1/bookings/6a2ffdb660198964d1ffaad7
```

### Sample Response

```text
Booking deleted successfully
```

---

# Reporting APIs

## Booking Summary

### Endpoint

```http
GET /api/v1/bookings/summary
```

### Sample Response

```json
{
  "totalBookings": 13,
  "totalRevenue": 290.0
}
```

---

## Bookings Per Event Report

### Endpoint

```http
GET /api/v1/bookings/report/events
```

### Sample Response

```json
{
  "Food & Music Carnival": 7,
  "Health & Wellness Expo": 2,
  "International Lantern Festival": 1,
  "Tech Innovation Expo": 1,
  "UTHM Cultural Festival 2026": 1,
  "Entrepreneurship Summit": 1
}
```

---

# Security

The system implements JWT Authentication and Role-Based Access Control (RBAC).

## Public Endpoints

- POST /api/auth/register
- POST /api/auth/login
- GET /api/v1/courses
- GET /api/v1/courses/{id}

## Admin Only Endpoints

- POST /api/v1/courses
- PUT /api/v1/courses/{id}
- DELETE /api/v1/courses/{id}
- DELETE /api/v1/bookings/{id}

---

# Business Rules

- Email must be unique.
- Users cannot book inactive events.
- Users cannot book sold-out events.
- Users cannot book past events.
- Seats are automatically reduced after successful bookings.
- Seats are restored after booking cancellation.
- Revenue is calculated automatically based on booking data.

---

# Developer

Aiman Firdaus

Capstone Project 2026

Event Booking System

