# OMS & Mobile – Architektura i Big Picture

## 1. Technologia aplikacji mobilnej
- **Flutter** (Android/iOS, 1 kod, natywna wydajność, łatwa integracja z REST, tryb offline, szybki rozwój, spójny UI/UX)

## 2. Statusy cyklu życia zlecenia (OrderStatus)
- PENDING (weryfikacja, np. adresów)
- NEW (gotowe do przydziału)
- PICKUP (odbiór)
- PSIP (odbiór transferu/zwrotu)
- LOAD (załadunek na samochód, skan przez kierowcę)
- TERM (skan na terminalu)
- POD (dostawa, ePoD)
- (łatwe rozszerzanie)

## 3. ePoD (Electronic Proof of Delivery)
- Podpis na ekranie
- Zdjęcia (optymalizacja rozdzielczości po stronie aplikacji)
- Możliwość kilku zdjęć do zlecenia

## 4. Integracja z ERP/WMS
- Synchroniczna przez REST API
- Kafka tylko do komunikacji wewnętrznej mikroserwisów

## 5. Audyt i historia zmian
- Log każdej zmiany statusu, edycji, ePoD (timestamp, użytkownik, źródło)
- Endpointy do przeglądania historii (admin/superuser)

## 6. Bezpieczeństwo i autoryzacja
- Hasła: bcrypt12
- OAuth2 (np. Keycloak/Spring Security OAuth2)
- Polityka haseł: zmiana co 3 miesiące, minimalna długość, złożoność
- Role: admin, superuser, dyspozytor, kierowca, klient
- Dostęp do endpointów i widoków kontrolowany przez role

## 7. Dashboard OMS – role
- Widoki i uprawnienia zależne od roli
- Możliwość rozbudowy o kolejne role/uprawnienia

---

## 8. High-level architektura (Big Picture)

```
[ERP/WMS] <---REST---> [OMS API Gateway] <---REST---> [OMS Microservices]
                                                    |-- Order Service
                                                    |-- Route Service
                                                    |-- Fleet Service
                                                    |-- User Service
                                                    |-- Audit Service
                                                    |-- Mobile Service
                                                    |-- Kafka (event bus, tylko wewnętrznie)

[OMS API Gateway] <---REST---> [Web Frontend (Vue.js)]
[OMS API Gateway] <---REST---> [Mobile App (Flutter)]
```

- Komunikacja z ERP/WMS przez REST
- Komunikacja wewnętrzna mikroserwisów przez REST/Kafka
- Frontend webowy (Vue.js) i mobilny (Flutter) korzystają z tych samych API

## 9. Szkic głównych kontraktów API (DTO)

### OrderDTO
- id
- status (OrderStatus)
- customer (klient)
- addressFrom, addressTo
- items (lista części, ilości, gabaryty)
- priority
- timestamps (utworzenie, zmiana statusu)
- assignedDriver
- ePoD (lista ePoDDTO)

### ePoDDTO
- id
- orderId
- signature (base64/png)
- photos (lista url lub base64, optymalizowane)
- timestamp
- userId

### UserDTO
- id
- username
- role
- passwordHash
- lastPasswordChange
- active

### AuditDTO
- id
- entityType (Order, User, ePoD, ...)
- entityId
- action (CREATE, UPDATE, STATUS_CHANGE, ...)
- userId
- timestamp
- details (json)

---

## 10. Przykładowy flow danych
1. Nowe zlecenie (Order) trafia przez REST do Order Service (status: PENDING)
2. Weryfikacja, zmiana statusu na NEW
3. Przydział do kierowcy, status PICKUP
4. Kierowca przez aplikację mobilną aktualizuje statusy (LOAD, TERM, POD)
5. W POD kierowca wykonuje ePoD (podpis, zdjęcia)
6. Wszystkie zmiany logowane w Audit Service
7. Frontend webowy i mobilny mają dostęp do historii i statusów przez API

---

## 11. Kolejne kroki
- Szczegółowe makiety UI (web, mobile)
- Szczegółowa specyfikacja endpointów REST
- Prototyp Order Service i Mobile Service (Spring Boot, Flutter)
- Testy integracyjne (REST, autoryzacja, role)
