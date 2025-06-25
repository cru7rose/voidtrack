# User Service - Developer Notes

## Overview
This service manages user profiles, authentication, and authorization for the VoidTracker OMS platform, including:
- User profile CRUD operations
- Role and permission management
- Integration with authentication providers (OAuth2, JWT)
- Contract-driven API (OpenAPI, JSON Schema, DTOs)

## Key Packages
- `controller` - REST API endpoints
- `dto` - Data Transfer Objects (records, contract-driven)
- `service` - Business logic
- `repository` - Persistence layer
- `security` - Authentication and authorization logic

## Development Guidelines
- All DTOs must have a matching JSON Schema and example payload
- All endpoints must be documented in OpenAPI and versioned
- Use contract and round-trip tests for all DTOs
- Validate all incoming/outgoing payloads against schemas
- Use constructor-based dependency injection
- No business logic in controllers (pure services)

## Quick Start
- Run contract tests: `mvn test`
- Validate schemas/examples: see scripts in project root
- API docs: `/swagger-ui.html` (after running service)

## Roadmap
- Integrate with external identity providers
- Add support for password policies, MFA, and audit logging
- Extend user roles and permissions for fine-grained access control
