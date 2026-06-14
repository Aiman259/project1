Markdown
# Instructor API Documentation

## Base URL
`http://localhost:8081/api/v1`

---

## Authentication

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
Login
POST /api/auth/login

Security: Public

Request Body:

JSON
{ 
"username": "admin", 
"password": "password123"
}
Response Body (JWT Token):

JSON
{ 
"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbmFpbWFuQGV4YW1wbGUuY29tIiwicm9sZXMiOiJBRE1JTiIsIm lhdCI6MTc4MTA3OTIzMywiZXhwIjoxNzgxMTY1NjMzfQ.LXAC_tldIGXV7hF-ZSxAbXmqIhjzW1jdHprLp1Y73Eg"
}
Instructor CRUD Endpoints
Get All Instructors
GET /api/v1/instructors

Security: Public

Response Body:

JSON
{ 
"content": [ 
{ 
"id": "6a28c985b405519aba3682d4", 
"name": "Aiman ​​Firdaus", 
"specialization": "Java & AI", 
"active": false, 
"yearsExperience": 0 
}, 
{ 
"id": "6a28c985b405519aba3682d5", 
"name": "Sarah Lee", 
"specialization": "Frontend Development", 
"active": false, 
"yearsExperience": 0 
}, 
{ 
"id": "6a2906a516d0745a200b5e65", 
"name": "John Doe Updated", 
"specialization": "Software Engineering", 
"active": true, 
"yearsExperience": 5 
}, 
{ 
"id": "6a2909b9daef7919ede38c56", 
"name": "John Doe Updated", 
"specialization": "Software Engineering", 
"active": true, 
"yearsExperience": 10 
}, 
{ 
"id": "6a2916c15251267a287f8acd", 
"name": "Alice Tan", 
"specialization": "Java", 
"active": true, 
"yearsExperience": 5 
} 
], 
"page": { 
"size": 5, 
"number": 0, 
"totalElements": 5, 
"totalPages": 1 
}
}
Create Instructor
POST /api/v1/instructors

Security: Requires Authentication (USER / ADMIN)

Request Body:

JSON
{ 
"id": "6a2916c15251267a287f8acd", 
"name": "Alice Tan", 
"specialization": "Java", 
"active": true, 
"yearsExperience": 0
}
Instructor update
PUT /api/v1/instructors/{id}

Security: Requires Authentication (USER / ADMIN)

Request Body:

JSON
{ 
"name": "Alice Tan", 
"specialization": "Java", 
"yearsOfExperience": 5
}
Delete Instructor
DELETE /api/v1/instructors/{id}

Security: Requires Authentication (ADMIN)

Example Request: DELETE /api/v1/instructors/6a2916c15251267a287f8acd

Search & Pagination
Search Endpoint
GET /api/v1/instructors/search?keyword={keyword}

Security: Public

Example Request: GET /api/v1/instructors/search?keyword=Aiman

Response Body Example:

JSON
{ 
"content": [ 
{ 
"id": "6a28c985b405519aba3682d4", 
"name": "Aiman ​​Firdaus", 
"specialization": "Java & AI", 
"active": false, 
"yearsExperience": 0 
} 
], 
"page": { 
"size": 5, 
"number": 0, 
"totalElements": 1, 
"totalPages": 1 
}
}
Pagination Endpoint
GET /api/v1/instructors?page={pageNumber}&size={pageSize}

Security: Public

Example Request: GET /api/v1/instructors?page=0&size=5

Response Body: (Same as Get All Instructors documentation)

Reporting Endpoints
Report by Status
GET /api/v1/reports/instructors/by-status

Security: Public

Response Body:

JSON
[ 
{ 
"status": "ACTIVE", 
"totalInstructors": 3 
}, 
{ 
"status": "INACTIVE", 
"totalInstructors": 2 
}
]
Report by Specialization
GET /api/v1/reports/instructors/by-specialization

Security: Public

Response Body:

JSON
[ 
{ 
"specialization": "Software Engineering", 
"totalInstructors": 2 
}, 
{ 
"specialization": "Java & AI", 
"totalInstructors": 1 
}, 
{ 
"specialization": "Frontend Development", 
"totalInstructors": 1 
}, 
{ 
"specialization": "Java", 
"totalInstructors": 1 
}
]