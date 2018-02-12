# Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for a simple Employee management application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Create Mysql database**
create database employee_management


**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**2. Build and run the app using maven**

```bash
mvn package
java -jar target/employee-management-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/employees
    
    POST /api/employee
    
    GET /api/employee/{employeeId}
    
    PUT /api/employee/{employeeId}
    
    DELETE /api/employee/{employeeId}

You can test them using postman or any other rest client.
