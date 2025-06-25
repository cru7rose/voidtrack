# Audit Service - Developer Notes

## Overview
This service logs and provides access to all audit events for the VoidTracker OMS platform, including:
- Logging of all status changes, edits, and ePoD events
- Query endpoints for audit history (admin/superuser)
- Contract-driven API (OpenAPI, JSON Schema, DTOs)

## Key Packages
- `controller` - REST API endpoints
- `dto` - Data Transfer Objects (records, contract-driven)
- `service` - Business logic
- `repository` - Persistence layer
- `config` - Service configuration

## Development Guidelines
- All DTOs must have a matching JSON Schema and example payload
- All endpoints must be documented in OpenAPI and versioned
- Use contract and round-trip tests for all DTOs
- Validate all incoming/outgoing payloads against schemas
- Use constructor-based dependency injection
- No business logic in controllers (pure services)
- All changes must be auditable and queryable

## Quick Start
- Run contract tests: `mvn test`
- Validate schemas/examples: see scripts in project root
- API docs: `/swagger-ui.html` (after running service)

## Roadmap
- Add advanced filtering and search for audit events
- Integrate with all OMS microservices for event publishing
- Support for export, compliance, and alerting
