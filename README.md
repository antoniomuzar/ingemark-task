# Ingemark Task – Product Management API

A Spring Boot RESTful API built for managing products with automatic EUR to USD price conversion using real-time exchange rates from the Croatian National Bank (HNB).

## Features

- ✅ Create a new product with EUR price
- ✅ Auto-calculates USD price from HNB API (`srednji tečaj`)
- ✅ Retrieve a product by ID
- ✅ Retrieve all products
- ✅ Input validation with meaningful error messages
- ✅ Clean DTO → Entity mapping using `ModelMapper`
- ✅ Unit tested `ProductService`
- ✅ Logs for currency conversion and error handling

---

## Tech Stack

- Java 17
- Spring Boot 3.4.4
- Spring MVC
- Spring Data JPA
- Hibernate
- PostgreSQL
- Jakarta Bean Validation (JSR-380)
- ModelMapper
- JUnit & Mockito
- DBeaver (used for DB access)

---

## API Endpoints

Base URL: `http://localhost:8080/api/products`

### POST `/`
Create a new product.

Request:
```json
{
  "code": "HNB1234567",
  "name": "Product Name",
  "priceEur": 100.0,
  "available": true

Response:
{
  "id": 1,
  "code": "HNB1234567",
  "name": "Product Name",
  "priceEur": 100.0,
  "priceUsd": 107.49,
  "available": true
}
}

### GET

GET /{id}
Fetch a product by ID.

GET /
Fetch all products.

 Running Locally
 Prerequisites:
-Java 17+
-Maven
-PostgreSQL running
-Set the application.properties or application.yml to point to your database

Clone and run :
git clone https://github.com/your-username/ingemark-task.git
cd ingemark-task
./mvnw spring-boot:run

Run the tests:

git clone https://github.com/your-username/ingemark-task.git
cd ingemark-task
./mvnw spring-boot:run


Notes:
-The exchange rate is fetched from: https://api.hnb.hr/tecajn/v2
-The rate "srednji_tecaj" is used and parsed safely (comma replaced with dot)
-If no exchange data is returned, an exception is thrown
-Rounding is handled to 2 decimal places via a utility class



Developed as part of a technical task for a mid-level Java Developer role at Ingemark.

Feel free to fork, extend, and reuse this project!




