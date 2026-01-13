# Product Review Microservices

This project demonstrates a simple microservices architecture using
Spring Boot, OpenFeign and Resilience4j.

The Product Service communicates with the Review Service via OpenFeign.
Resilience patterns such as Circuit Breaker, Retry and Fallback are applied
to prevent cascading failures and ensure graceful degradation.

An Adapter layer is used to isolate integration and resilience concerns
from the domain logic, following principles inspired by Clean / Hexagonal
Architecture.

The project focuses on clean separation of responsibilities, resilience,
and fault-tolerant service-to-service communication.
