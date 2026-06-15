# API Documentation

## Event Booking System

### Base URL

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

### Response

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

### Response

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

---

## Get Event By ID

### Endpoint

```http
GET /api/v1/courses/{id}
```

### Description

Retrieve a specific event using its ID.

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

### Response

```json
{
  "id": "event_id",
  "title": "UTHM Cultural Festival 2026",
  "status": "ACTIVE"
}
```

---

## Update Event (Admin Only)

### Endpoint

```http
PUT /api/v1/courses/{id}
```

### Description

Update event information.

---

## Delete Event (Admin Only)

### Endpoint

```http
DELETE /api/v1/courses/{id}
```

### Description

Delete an event from the system.

---

# Booking APIs

## Create Booking

### Endpoint

```http
POST /api/v1/bookings
```

### Description

Create a booking for an event.

---

## Get All Bookings

### Endpoint

```http
GET /api/v1/bookings
```

### Description

Retrieve all bookings in the system.

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
GET /api/v1/bookings/user/{email}
```

### Example

```http
GET /api/v1/bookings/user/Amin@gmail.com
```

### Description

Retrieve bookings belonging to a specific user.

---

## Delete Booking (Admin Only)

### Endpoint

```http
DELETE /api/v1/bookings/{id}
```

### Description

Delete a booking record.

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

### Public Endpoints

* POST /api/auth/register
* POST /api/auth/login
* GET /api/v1/courses
* GET /api/v1/courses/{id}

### Admin Only Endpoints

* POST /api/v1/courses
* PUT /api/v1/courses/{id}
* DELETE /api/v1/courses/{id}
* DELETE /api/v1/bookings/{id}

---

# Business Rules

* Email must be unique.
* Users cannot book inactive events.
* Users cannot book sold-out events.
* Users cannot book past events.
* Seats are automatically reduced after successful bookings.
* Seats are restored after booking cancellation.
* Revenue is calculated automatically based on booking data.

---

# Developer

Aiman Firdaus

Capstone Project 2026

