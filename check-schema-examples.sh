#!/bin/bash
# Skrypt do sprawdzania, czy wszystkie JSON Schema mają przykładowe payloady
set -e

SCHEMA_DIR="schemas/json/json"
EXAMPLE_DIR="schemas/json/example"

for schema in $SCHEMA_DIR/*.json; do
  name=$(basename "$schema" _v1.json)
  if ! ls $EXAMPLE_DIR/${name}_example.json &>/dev/null; then
    echo "Brak przykładowego payloadu dla: $name"
  fi
done

echo "Skanowanie zakończone."
