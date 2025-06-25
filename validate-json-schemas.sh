#!/bin/bash
# Skrypt do walidacji wszystkich plików JSON Schema w repozytorium
set -e

SCHEMA_DIRS=(schemas/json/json)

for dir in "${SCHEMA_DIRS[@]}"; do
  for file in $dir/*.json; do
    echo "Waliduję: $file"
    ajv validate -s "$file" -d "$file" || { echo "Błąd walidacji: $file"; exit 1; }
  done
done

echo "Wszystkie schematy JSON są poprawne."
