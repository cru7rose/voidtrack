#!/bin/bash
# Skrypt do sprawdzania, czy wszystkie DTO mają odpowiadający im JSON Schema
set -e

DTO_DIR="voidtracker-commons/src/main/java/com/voidtracker/oms/commons/dto"
SCHEMA_DIR="schemas/json/json"

for dto in $DTO_DIR/*.java; do
  name=$(basename "$dto" .java)
  if ! ls $SCHEMA_DIR/${name}_v1.json &>/dev/null; then
    echo "Brak JSON Schema dla: $name"
  fi
done

echo "Skanowanie zakończone."
