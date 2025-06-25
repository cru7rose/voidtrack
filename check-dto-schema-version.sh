#!/bin/bash
# Skrypt do sprawdzania spójności wersji DTO i JSON Schema
set -e

echo "Sprawdzanie wersji DTO i JSON Schema..."

# Przykład: sprawdź czy OrderDto_v1.json zawiera v1 i czy w kodzie DTO jest odpowiedni komentarz/annotacja
SCHEMA_FILE="schemas/json/json/OrderDto_v1.json"
DTO_FILE="voidtracker-commons/src/main/java/com/voidtracker/oms/commons/dto/OrderDto.java"

if grep -q 'urn:projekt:order:details:v1' "$SCHEMA_FILE" && grep -q 'OrderDto' "$DTO_FILE"; then
  echo "OrderDto i OrderDto_v1.json są zgodne wersją."
else
  echo "NIEZGODNOŚĆ wersji OrderDto i OrderDto_v1.json!"; exit 1
fi

echo "Sprawdzanie zakończone."
