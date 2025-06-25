# VoidTracker OMS - Unified Environment Setup

## Overview
This project is a modular, contract-driven Order Management System (OMS) for logistics, built with Java Spring Boot (backend microservices) and Vue.js (frontend). It follows the Qodo Manifesto: testable, documented, versioned, and ready for change.

## Services
- **order-service** (port 8081): Order management, route, tracking
- **user-service** (port 8082): User profiles, roles, authentication
- **audit-service** (port 8083): Audit logging, event history

## Quick Start (Backend)
1. **Build all services:**
   ```sh
   ./mvnw clean package
   ```
2. **Run all services with Docker Compose:**
   ```sh
   docker-compose up --build
   ```
   - order-service: http://localhost:8081
   - user-service: http://localhost:8082
   - audit-service: http://localhost:8083

3. **API Documentation (Swagger UI):**
   - Order: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
   - User: [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
   - Audit: [http://localhost:8083/swagger-ui.html](http://localhost:8083/swagger-ui.html)

## Quick Start (Frontend)
1. **Navigate to the frontend directory (if present):**
   ```sh
   cd frontend
   npm install
   npm run serve
   ```
2. **Configure API base URLs in the frontend to match backend ports.**

## CORS
All backend services are CORS-enabled for local frontend development (Vue, React, etc.).

## Extending/Testing
- All APIs are contract-driven (OpenAPI, JSON Schema, DTOs).
- Add new modules/services as needed (see Qodo Manifesto and ARCHITECTURE_OVERVIEW.md).
- Test with real frontend or API tools (Swagger UI, Postman).

## Roadmap
- Add persistent storage (PostgreSQL, MongoDB)
- Integrate authentication (OAuth2/JWT)
- Expand frontend (Vue) for full OMS workflows
- Add CI/CD and automated contract tests
