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

🔹 POST /
Create a new product

🔹 Request Example
{
  "code": "HNB1234567",
  "name": "Product Name",
  "priceEur": 100.0,
  "available": true
}


