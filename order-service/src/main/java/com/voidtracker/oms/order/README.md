# Order Service - Developer Notes

## Overview
This service handles all order management logic for the VoidTracker OMS platform, including:
- Order creation, update, and status management
- Integration with route, tracking, and audit services
- Contract-driven API (OpenAPI, JSON Schema, DTOs)

## Key Packages
- `controller` - REST API endpoints
- `dto` - Data Transfer Objects (records, contract-driven)
- `service` - Business logic
- `repository` - Persistence layer
- `route`, `tracking`, `mobile` - Integration points for other modules

## Development Guidelines
- All DTOs must have a matching JSON Schema and example payload
- All endpoints must be documented in OpenAPI and versioned
- Use contract and round-trip tests for all DTOs
- Validate all incoming/outgoing payloads against schemas
- Use constructor-based dependency injection
- No business logic in controllers (pure services)
- All changes must be auditable (integrate with Audit Service)

## Quick Start
- Run contract tests: `mvn test`
- Validate schemas/examples: see scripts in project root
- API docs: `/swagger-ui.html` (after running service)

## Roadmap
- Extend to support advanced filtering, search, and history
- Integrate with ERP/WMS and mobile app
- Add support for ePoD, notifications, and analytics
