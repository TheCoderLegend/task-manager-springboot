# 🚀 Task Manager API (Spring Boot + MongoDB)

A production-ready backend application built using **Spring Boot** and **MongoDB** that provides REST APIs to manage tasks efficiently.

---

## 📌 📖 Project Overview

This project is a **Task Management REST API** that allows users to:

* Create tasks
* View all tasks
* Get task by ID
* Update tasks
* Delete tasks

It follows **clean architecture principles** and includes:

* Validation
* Global Exception Handling
* MongoDB integration

---

## 🧱 🏗️ Architecture

```
Controller → Service → Repository → MongoDB
```

### 📂 Project Structure

```
src/main/java/com/vishnu/taskmanager
│
├── controller        # REST Controllers
├── service           # Business Logic
├── repository        # Database Layer
├── model             # Entity Classes
├── exception         # Global Exception Handling
```

---

## ⚙️ 🛠️ Tech Stack

* Java 17+
* Spring Boot
* MongoDB
* Spring Data MongoDB
* Maven

---

## 🚀 ▶️ How to Run Locally

### 🔹 1. Clone the Repository

```bash
git clone https://github.com/TheCoderLegend/task-manager-springboot.git
cd task-manager-springboot
```

---

### 🔹 2. Start MongoDB

```bash
mongod
```

---

### 🔹 3. Configure Database

Update:

```
src/main/resources/application.properties
```

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/taskdb
```

---

### 🔹 4. Run the Application

```bash
./mvnw spring-boot:run
```

---

### 🔹 5. Server Runs At

```
http://localhost:8080
```

---

## 📡 🔗 API Endpoints

### ✅ Create Task

```http
POST /tasks
```

#### Request Body:

```json
{
  "title": "Learn Spring Boot",
  "description": "Build REST API",
  "completed": false
}
```

#### Response:

```json
{
  "id": "65f1abc123",
  "title": "Learn Spring Boot",
  "description": "Build REST API",
  "completed": false,
  "createdAt": "2026-03-30T10:30:00",
  "updatedAt": null
}
```

---

### ✅ Get All Tasks

```http
GET /tasks
```

---

### ✅ Get Task By ID

```http
GET /tasks/{id}
```

---

### ✅ Update Task

```http
PUT /tasks/{id}
```

#### Request Body:

```json
{
  "title": "Updated Task",
  "description": "Updated description",
  "completed": true
}
```

---

### ❌ Delete Task

```http
DELETE /tasks/{id}
```

---

## ⚠️ 🧪 Validation Example

If invalid request:

```json
{
  "title": ""
}
```

#### Response:

```json
{
  "title": "Title is required"
}
```

---

## ❗ 🚨 Error Handling

Example:

```json
{
  "message": "Task not found"
}
```

Handled globally using:

* `@RestControllerAdvice`
* Custom Exceptions

---

## 🧪 🧰 Testing APIs

You can test APIs using:

* Postman
* curl

### Example:

```bash
curl -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{"title":"Task 1","description":"Test","completed":false}'
```

---

## 💡 🔥 Features Implemented

* CRUD Operations
* MongoDB Integration
* Validation
* Global Exception Handling
* Clean Architecture

---

## 🚀 🔮 Future Improvements

* JWT Authentication
* Swagger API Documentation
* Pagination & Sorting
* Logging
* Docker Support
* Deployment (AWS / Render)

---

## 👨‍💻 Author

**Vishnu V R**

* GitHub: https://github.com/TheCoderLegend

---
