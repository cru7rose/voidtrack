# VoidTracker OMS: Architecture Overview

## MVP Modules (Phase 1)

- **Order Management**: Core order lifecycle, sync/async creation, status, soft-delete, search/filter, history.
- **Route Planning & Optimization**: Integration stubs for OSRM/GraphHopper, service interface for route calculation, DTOs for route requests/results.
- **Real-time Tracking**: GPS event DTOs, Kafka/IoT integration stubs, tracking service, event consumer/producer.
- **Mobile API**: Controller for driver app (task list, status update, ePoD, barcode scanning), DTOs for mobile flows.
- **Basic Dashboard API**: Controller for dispatcher dashboard (order/task list, map data, alerts).

## Future Modules (Phase 2+)

- **Fleet & Carrier Management**: Vehicle/driver entities, repositories, services, carrier performance.
- **Document & Compliance**: ePoD, document upload endpoints, DTOs, compliance checks.
- **Analytics & KPI Reporting**: Analytics service, DTOs, endpoints for BI/KPI.
- **Integration Layer**: ERP/WMS adapters, external API connectors, event bridges.
- **Notification/Communication**: Alert/notification service, DTOs, endpoints for system/user alerts.
- **Customer/Partner Portal API**: Controller, DTOs for client self-service, order tracking, document download.
- **Billing/Settlement**: Freight audit, cost calculation, invoice DTOs, settlement endpoints.
- **CO2/Eco Analytics**: Emission tracking, eco route suggestions, reporting.

## Package Structure (Java)

- `order` — Order management (controller, service, dto, repository, error, validation)
- `route` — Route planning/optimization (controller, service, integration, dto)
- `tracking` — Real-time tracking (service, event, integration)
- `mobile` — Mobile API (controller, dto)
- `dashboard` — Dispatcher dashboard API (controller, dto)
- `fleet` — Fleet/carrier management (entity, service, repository, dto)
- `document` — Document/compliance (controller, service, dto)
- `analytics` — Analytics/KPI (service, controller, dto)
- `integration` — ERP/WMS/external API adapters
- `notification` — Notification/alerting (service, dto)
- `portal` — Customer/partner portal API (controller, dto)

## Roadmap

- **Phase 0**: Analysis, architecture, UI/UX prototyping, tech stack selection
- **Phase 1**: MVP — Order, Route, Tracking, Mobile, Dashboard
- **Phase 2+**: Fleet, Document, Analytics, Integration, Notification, Portal, Billing, Eco

## Notes
- All modules are microservice-ready, API-first, and cloud-native.
- All endpoints are OpenAPI documented, versioned, and secured (JWT, roles).
- All DTOs and schemas are versioned, validated, and tested.
- All modules are designed for future extension and integration.
