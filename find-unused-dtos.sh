#!/bin/bash
# Skrypt do znajdowania DTO bez testów kontraktowych
set -e

echo "Szukam DTO bez testów kontraktowych..."
DTO_DIR="voidtracker-commons/src/main/java/com/voidtracker/oms/commons/dto"
TEST_DIR="order-service/src/test/java/com/voidtracker/oms/order/dto"

for dto in $DTO_DIR/*.java; do
  name=$(basename "$dto" .java)
  if ! ls $TEST_DIR/${name}ContractTest.java &>/dev/null; then
    echo "Brak testu kontraktowego dla: $name"
  fi
done

echo "Skanowanie zakończone."
