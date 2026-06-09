# Instructor API Documentation

## Base URL
http://localhost:8081/api/v1

---

## 1. Authentication

### Register
**POST** `/api/auth/register`
* **Security:** Public
* **Request Body:**
```json
{
  "username": "admin",
  "password": "password123",
  "role": "ADMIN"
}
