# Katalog DTO i Schematów dla OMS & Mobile

## 1. Zasady projektowania DTO
- Nazewnictwo: jasne, kontekstowe, zgodne z konwencją (np. CreateOrderRequestDto, OrderConfirmationResponseDto)
- Granularność: osobne DTO do list, szczegółów, żądań i odpowiedzi
- Niezmienność: preferowane immutable (np. Java record)
- Walidacja: adnotacje (np. JSR 380), JSON Schema/XSD
- Mapowanie: dedykowane komponenty (np. MapStruct)
- Wersjonowanie: wersje w $id JSON Schema, targetNamespace XSD

## 2. Katalog głównych DTO
| Nazwa DTO                    | Opis/Cel                                      | Przykładowy JSON Schema ID                |
|------------------------------|-----------------------------------------------|-------------------------------------------|
| UserProfileDto               | Publiczny profil użytkownika                  | urn:projekt:user:profile:v1               |
| CreateOrderRequestDto        | Żądanie utworzenia zamówienia                 | urn:projekt:order:create:request:v1       |
| OrderConfirmationResponseDto | Potwierdzenie utworzenia zamówienia           | urn:projekt:order:confirm:response:v1     |
| ProductDetailsDto            | Szczegóły produktu                            | urn:projekt:product:details:v1            |
| ApiErrorDto                  | Standardowy format błędu API                  | urn:projekt:common:error:v1               |
| OrderDto                     | Szczegóły zlecenia (pełne)                    | urn:projekt:order:details:v1              |
| OrderListItemDto             | Podsumowanie zlecenia (lista)                 | urn:projekt:order:list:item:v1            |
| ePoDDto                      | Elektroniczne potwierdzenie dostawy           | urn:projekt:order:epod:v1                 |
| AuditDto                     | Zdarzenie audytowe                            | urn:projekt:audit:event:v1                |

## 3. Przykładowa definicja JSON Schema (OrderDto)
```json
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "$id": "urn:projekt:order:details:v1",
  "title": "Order Details",
  "description": "Szczegóły zlecenia transportowego (OMS/TMS)",
  "type": "object",
  "properties": {
    "orderId": { "type": "string", "format": "uuid" },
    "status": { "type": "string", "enum": ["PENDING", "NEW", "PICKUP", "PSIP", "LOAD", "TERM", "POD"] },
    "priority": { "type": "string", "enum": ["NORMAL", "URGENT"] },
    "pickup": {
      "type": "object",
      "properties": {
        "customer": { "type": "string" },
        "alias": { "type": "string" },
        "country": { "type": "string", "pattern": "^[A-Z]{2}$" },
        "addressId": { "type": "integer" },
        "postalCode": { "type": "string", "pattern": "^\\d{2}-\\d{3}$" },
        "city": { "type": "string" },
        "street": { "type": "string" },
        "streetNumber": { "type": "string" },
        "name": { "type": "string" },
        "attention": { "type": "string" },
        "route": { "type": "string" },
        "routePart": { "type": "string" },
        "type": { "type": "string" },
        "manifestDate": { "type": "string", "format": "date" },
        "windowFrom": { "type": "string", "format": "date-time" },
        "windowTo": { "type": "string", "format": "date-time" },
        "mail": { "type": "string", "format": "email" },
        "phone": { "type": "string" },
        "note": { "type": "string" }
      },
      "required": ["customer", "country", "city", "street", "streetNumber", "postalCode"]
    },
    "delivery": {
      "type": "object",
      "properties": {
        "customer": { "type": "string" },
        "alias": { "type": "string" },
        "country": { "type": "string", "pattern": "^[A-Z]{2}$" },
        "addressId": { "type": "integer" },
        "postalCode": { "type": "string", "pattern": "^\\d{2}-\\d{3}$" },
        "city": { "type": "string" },
        "street": { "type": "string" },
        "streetNumber": { "type": "string" },
        "name": { "type": "string" },
        "attention": { "type": "string" },
        "route": { "type": "string" },
        "routePart": { "type": "string" },
        "type": { "type": "string" },
        "manifestDate": { "type": "string", "format": "date" },
        "sla": { "type": "string", "format": "date-time" },
        "windowFrom": { "type": "string", "format": "date-time" },
        "windowTo": { "type": "string", "format": "date-time" },
        "mail": { "type": "string", "format": "email" },
        "phone": { "type": "string" },
        "note": { "type": "string" }
      },
      "required": ["customer", "country", "city", "street", "streetNumber", "postalCode"]
    },
    "package": {
      "type": "object",
      "properties": {
        "barcode1": { "type": "string" },
        "barcode2": { "type": "string" },
        "colli": { "type": "integer" },
        "weight": { "type": "number" },
        "volume": { "type": "number" },
        "routeDistance": { "type": "number" },
        "serviceType": { "type": "string" },
        "packageDimensions": {
          "type": "object",
          "properties": {
            "length": { "type": "number" },
            "width": { "type": "number" },
            "height": { "type": "number" }
          },
          "required": ["length", "width", "height"]
        },
        "driverNote": { "type": "string" },
        "invoiceNote": { "type": "string" },
        "price": { "type": "number" },
        "currency": { "type": "string", "pattern": "^[A-Z]{3}$" },
        "adr": { "type": "boolean" }
      },
      "required": ["barcode1", "colli", "weight", "serviceType"]
    },
    "timestamps": {
      "type": "object",
      "properties": {
        "created": { "type": "string", "format": "date-time" },
        "lastStatusChange": { "type": "string", "format": "date-time" }
      },
      "required": ["created"]
    },
    "assignedDriver": { "type": "string" },
    "epod": {
      "type": "array",
      "items": { "$ref": "urn:projekt:order:epod:v1" }
    }
  },
  "required": ["orderId", "status", "priority", "pickup", "delivery", "package", "timestamps"]
}
```

## 4. Przykładowy payload (OrderDto)
```json
{
  "orderId": "a1b2c3d4-e5f6-7890-1234-567890abcdef",
  "status": "PICKUP",
  "priority": "URGENT",
  "pickup": {
    "customer": "DANXILS Sp. z o.o.",
    "alias": "WAW-CENTRAL",
    "country": "PL",
    "addressId": 101,
    "postalCode": "00-001",
    "city": "Warszawa",
    "street": "Logistyczna",
    "streetNumber": "12A",
    "name": "Magazyn Centralny",
    "attention": "Odbiór przez kierowcę X",
    "route": "WAW-POZ",
    "routePart": "F",
    "type": "FROM",
    "manifestDate": "2024-06-10",
    "windowFrom": "2024-06-10T08:00:00Z",
    "windowTo": "2024-06-10T09:00:00Z",
    "mail": "magazyn@danxils.com",
    "phone": "+48221234567",
    "note": "Załadunek na rampie 3"
  },
  "delivery": {
    "customer": "Serwis Poznań",
    "alias": "POZ-SERWIS",
    "country": "PL",
    "addressId": 202,
    "postalCode": "60-101",
    "city": "Poznań",
    "street": "Przemysłowa",
    "streetNumber": "1",
    "name": "Serwis Główny",
    "attention": "Dostawa do rąk własnych",
    "route": "WAW-POZ",
    "routePart": "D",
    "type": "DELIVERY",
    "manifestDate": "2024-06-10",
    "sla": "2024-06-10T12:00:00Z",
    "windowFrom": "2024-06-10T10:00:00Z",
    "windowTo": "2024-06-10T12:00:00Z",
    "mail": "serwis@danxils.com",
    "phone": "+48601234567",
    "note": "Dostawa na bramę serwisową"
  },
  "package": {
    "barcode1": "PLDANX1234567890",
    "barcode2": "PLDANX0987654321",
    "colli": 2,
    "weight": 15.5,
    "volume": 0.12,
    "routeDistance": 310.0,
    "serviceType": "express",
    "packageDimensions": {
      "length": 80.0,
      "width": 60.0,
      "height": 40.0
    },
    "driverNote": "Uwaga na delikatny ładunek",
    "invoiceNote": "Faktura dołączona do przesyłki",
    "price": 350.00,
    "currency": "PLN",
    "adr": false
  },
  "timestamps": {
    "created": "2024-06-10T07:30:00Z",
    "lastStatusChange": "2024-06-10T08:05:00Z"
  },
  "assignedDriver": "john_doe",
  "epod": []
}
```

## 4a. Przykładowy payload (ApiErrorDto)
```json
{
  "errorCode": "ORDER_NOT_FOUND",
  "message": "Nie znaleziono zlecenia o podanym ID.",
  "details": "orderId: a1b2c3d4-e5f6-7890-1234-567890abcdef"
}
```

## 5. Struktura katalogu DTO i schematów
- /dto
  - UserProfileDto.java
  - CreateOrderRequestDto.java
  - OrderConfirmationResponseDto.java
  - ProductDetailsDto.java
  - ApiErrorDto.java
  - OrderDto.java
  - OrderListItemDto.java
  - ePoDDto.java
  - AuditDto.java
- /schemas/json
  - UserProfile_v1.json
  - CreateOrderRequest_v1.json
  - OrderConfirmationResponse_v1.json
  - ProductDetails_v1.json
  - ApiError_v1.json
  - OrderDetails_v1.json
  - OrderListItem_v1.json
  - ePoD_v1.json
  - AuditEvent_v1.json
- /schemas/xsd
  - UserProfile_v1.xsd
  - CreateOrder_v1.xsd
  - OrderConfirmation_v1.xsd
  - Product_v1.xsd
  - ApiError_v1.xsd
  - OrderTypes_v1.xsd
  - ePoD_v1.xsd
  - AuditEvent_v1.xsd

## 6. Kolejne kroki
- Utworzenie plików DTO i schematów zgodnie z powyższą strukturą
- Implementacja walidacji na granicy API (JSON Schema/XSD)
- Automatyzacja walidacji w CI/CD
- Dokumentacja i wersjonowanie kontraktów
