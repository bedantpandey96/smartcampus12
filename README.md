

# Smart Campus REST API (JAX-RS)

## 📌 Overview

This project implements a *RESTful Smart Campus API* using *JAX-RS (Jakarta RESTful Web Services)*.
The system manages *Rooms, Sensors, and Sensor Readings* across a campus environment.

The API follows REST principles including:

* Resource-based architecture
* Proper HTTP methods and status codes
* JSON-based communication
* Logical resource hierarchy

---

## 🌐 API Design

### Base URL

/api/v1

### Core Resources

* /rooms → Manage rooms
* /sensors → Manage sensors
* /sensors/{id}/readings → Manage sensor readings

---

### 📍 Endpoints

#### Rooms

* GET /api/v1/rooms → Get all rooms
* POST /api/v1/rooms → Create a room
* GET /api/v1/rooms/{id} → Get room details
* DELETE /api/v1/rooms/{id} → Delete room

#### Sensors

* GET /api/v1/sensors → Get all sensors
* GET /api/v1/sensors?type=CO2 → Filter sensors
* POST /api/v1/sensors → Create sensor

#### Readings

* GET /api/v1/sensors/{id}/readings → Get readings
* POST /api/v1/sensors/{id}/readings → Add reading

---

## ⚙️ Technologies Used

* Java
* JAX-RS (Jersey)
* Maven
* JSON
* In-memory storage (HashMap, ArrayList)

---

## 🛠️ Setup & Run

### 1. Clone repo

git clone https://github.com/bedantpandey96/smartcampus12.git
cd smartcampus12

### 2. Build

mvn clean install

### 3. Run server

mvn exec:java -Dexec.mainClass="org.bedant.Main"

---

## 🧪 Sample curl Commands

### Get all rooms

curl -X GET http://localhost:8080/api/v1/rooms

### Create room

curl -X POST http://localhost:8080/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{"id":"LIB-301","name":"Library","capacity":100}'

### Delete room

curl -X DELETE http://localhost:8080/api/v1/rooms/LIB-301

### Create sensor

curl -X POST http://localhost:8080/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{"id":"TEMP-001","type":"Temperature","status":"ACTIVE","roomId":"LIB-301"}'

### Filter sensors

curl -X GET "http://localhost:8080/api/v1/sensors?type=Temperature"

---

## ⚠️ Error Handling

| Scenario               | Status                    |
| ---------------------- | ------------------------- |
| Room not empty         | 409 Conflict              |
| Invalid room reference | 422 Unprocessable Entity  |
| Sensor unavailable     | 403 Forbidden             |
| Server error           | 500 Internal Server Error |

Custom Exception Mappers ensure no internal stack traces are exposed.

---

## 🧠 Report Answers

### Q1: JAX-RS Resource Lifecycle

By default, JAX-RS creates a new instance of a resource class for each request. This avoids shared state issues but requires careful handling of shared data structures such as HashMaps to ensure consistency and prevent race conditions.

---

### Q2: HATEOAS

HATEOAS improves REST APIs by including links in responses, allowing clients to dynamically navigate resources instead of relying on hardcoded endpoints. This improves flexibility and maintainability.

---

### Q3: Returning IDs vs Full Objects

Returning only IDs reduces bandwidth but requires additional requests. Returning full objects increases payload size but simplifies client-side processing.

---

### Q4: DELETE Idempotency

DELETE is idempotent because repeated deletion of the same resource results in the same system state (resource remains deleted).

---

### Q5: Content-Type Mismatch

If a client sends data in an unsupported format, JAX-RS returns a 415 Unsupported Media Type error.

---

### Q6: QueryParam vs PathParam

Query parameters are better for filtering because they allow flexible and optional criteria, unlike path parameters which represent fixed resource structure.

---

### Q7: Sub-resource Locator Benefits

It improves modularity and scalability by separating nested logic into different classes, avoiding large monolithic controllers.

---

### Q8: HTTP 422 vs 404

422 is more appropriate because the request is syntactically correct but semantically invalid due to missing linked resource.

---

### Q9: Security Risks of Stack Traces

Exposing stack traces can reveal internal implementation details, making the system vulnerable to attacks.

---

### Q10: Logging Filters

Using filters centralizes logging logic and avoids duplication across resource methods.

---

## 👥 Contributors

* Bedant Pandey (Team Lead)
* Prabin Pandey

---

## 🚀 Future Improvements

* Database integration
* Authentication system
* Web UI dashboard
* Real-time sensor updates

---
