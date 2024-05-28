# Quiz Application Microservices

## Overview
This Quiz Application is built using a microservice architecture, leveraging the power of Spring Boot and Netflix OSS components. It consists of multiple services that work together to provide a comprehensive quiz platform.

## Architecture
The application is structured around the microservice architectural style, with services that are loosely coupled and independently deployable. The key components include:

- **Service Registry (Eureka)**: All services register with the Eureka server, which provides a central point for service discovery.
- **Feign Client**: Services communicate with each other using Feign clients, which simplify the process of making HTTP requests between microservices.

## Services

### Quiz Service
- **Description**: Manages quiz data and interactions.
- **Port**: 8080

  ### Question Service
- **Description**: Manages request coming from quiz service 
- **Port**: 8081

  ### Prerequisites
- Java JDK 11 or later
- Maven 
- PostgreSQL
### Running the Application
1. Start the Eureka server.
2. Launch each microservice individually.
3. Ensure all services are registered with Eureka.

## Dependencies
List of key dependencies used in the project.

- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud OpenFeign
- Spring Data JPA
- PostgreSQL Driver


 ## Contact
Sarthak Tripathy
Ph. No.: +918455877729
Email: sarthaktripathy1621@gmail.com




