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

**POST** /
Create a new product

 Request Example
{
  "code": "HNB1234567",
  "name": "Product Name",
  "priceEur": 100.0,
  "available": true
}

 Response Example
{
  "id": 1,
  "code": "HNB1234567",
  "name": "Product Name",
  "priceEur": 100.0,
  "priceUsd": 107.49,
  "available": true
}

 **GET** /{id}
Fetch a product by ID.

 **GET** /
Fetch all products.

## Running Locally
-Prerequisites
-Java 17+
-Maven
-PostgreSQL running locally
-Correct database settings in application.properties


## Clone and Run

git clone https://github.com/antoniomuzar/ingemark-task.git
cd ingemark-task
./mvnw spring-boot:run


## Exchange Rate Info
-Uses official rates from HNB API

-Uses "srednji_tecaj" (mid-rate) for EUR → USD conversion

-Safely parses rates (comma replaced with dot)

-Throws a descriptive exception if the API data is missing or malformed

-Rounds USD prices to 2 decimal places via a utility method

## Developed for 

This project was created as a technical assignment for a mid-level Java Developer role at Ingemark.

Feel free to fork, extend, or reuse it!

