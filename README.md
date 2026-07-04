# Spring Boot Eureka Microservices Registry

A beginner-friendly Spring Boot microservices project demonstrating **Netflix Eureka Service Discovery**. This project consists of a Eureka Server and two microservices that register themselves with Eureka and communicate using **service discovery** instead of hardcoded URLs.

---

## Project Overview

This project was built to understand the fundamentals of **Spring Cloud Netflix Eureka** and how service discovery works in a microservices architecture.

Instead of calling services using fixed hostnames and ports, the microservices discover each other dynamically through the Eureka Server.

---

## Project Architecture

```text
                    Client
                       |
                       |
                       v
                Service One
                       |
      (Discovers SERVICE-TWO)
                       |
                       v
               Eureka Server
                       |
                       v
                Service Two
```

---

## Project Structure

```text
springboot-eureka-microservices-registry
│
├── eureka-server
│
├── service-one
│
└── service-two
```

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud LoadBalancer
- Spring Web
- Maven

---

## Modules

### Eureka Server

- Acts as the Service Registry.
- Maintains information about all running microservices.
- Allows services to register and discover one another.

**Runs on:**

```text
http://localhost:8761
```

---

### Service One

- Registers itself with Eureka.
- Provides a simple REST endpoint.
- Calls **Service Two** using its service name (`SERVICE-TWO`) instead of a hardcoded URL.

**Runs on:**

```text
http://localhost:8081
```

**Endpoints**

```http
GET /
```

**Response**

```text
Hello, Welcome to Service One
```

```http
GET /call
```

**Response**

```text
Service One received -> Hello, Welcome to Service Two
```

---

### Service Two

- Registers itself with Eureka.
- Provides a simple REST endpoint.

**Runs on:**

```text
http://localhost:8082
```

**Endpoint**

```http
GET /
```

**Response**

```text
Hello, Welcome to Service Two
```

---

## How Eureka Works

1. Start the Eureka Server.
2. Start Service One and Service Two.
3. Both services automatically register with Eureka.
4. The Eureka Dashboard displays all registered services.
5. Service One requests `SERVICE-TWO`.
6. Eureka returns the running instance of Service Two.
7. Service One communicates with Service Two successfully.

---

## Features Demonstrated

- Eureka Server setup
- Eureka Client registration
- Automatic service registration
- Service discovery
- Inter-service communication
- Dynamic service lookup using service names
- Client-side load balancing support
- Heartbeat mechanism

---

## What I Learned

During this project, I learned:

- The purpose of Service Discovery in a microservices architecture.
- Why hardcoded URLs are not suitable for scalable applications.
- How Eureka Server maintains a registry of available services.
- How microservices automatically register with Eureka at startup.
- How Eureka uses heartbeats to monitor service health.
- How one microservice discovers another using its service name.
- How `@LoadBalanced RestTemplate` resolves service names to actual service instances.
- How services continue to communicate even if ports change, without modifying application code.
- The importance of loose coupling between microservices.
- The basics of client-side load balancing with multiple service instances.

---

## How to Run

### 1. Start Eureka Server

```bash
mvn spring-boot:run
```

Open:

```text
http://localhost:8761
```

### 2. Start Service Two

```bash
mvn spring-boot:run
```

### 3. Start Service One

```bash
mvn spring-boot:run
```

### 4. Test the APIs

**Service One**

```text
http://localhost:8081/
```

**Service Two**

```text
http://localhost:8082/
```

**Service-to-Service Communication**

```text
http://localhost:8081/call
```

**Expected Response**

```text
Service One received -> Hello, Welcome to Service Two
```

---

## Future Improvements

- Spring Cloud Gateway
- OpenFeign Client
- Spring Cloud Config Server
- Resilience4j Circuit Breaker
- Docker
- Kubernetes
- Distributed Tracing
- Centralized Logging
- Monitoring with Prometheus and Grafana

---

## Learning Outcome

This project provided practical experience with **Spring Boot Microservices** and **Spring Cloud Netflix Eureka**. It helped me understand how service registration, service discovery, dynamic endpoint resolution, and client-side load balancing work together to build scalable and loosely coupled distributed applications.

---

## Author

**Manoj Kumar Vadiithya**

- GitHub: https://github.com/ManojKumarVadiithya
- LinkedIn: https://www.linkedin.com/in/manoj1606/
