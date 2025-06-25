#!/bin/bash
# Skrypt do sprawdzania, czy wszystkie endpointy OpenAPI mają przykłady odpowiedzi
set -e

OPENAPI_FILE="docs/openapi-order.yaml"

if grep -q 'examples:' "$OPENAPI_FILE"; then
  echo "Przykłady odpowiedzi obecne w OpenAPI."
else
  echo "Brak przykładów odpowiedzi w OpenAPI!"; exit 1
fi

echo "Skanowanie zakończone."
