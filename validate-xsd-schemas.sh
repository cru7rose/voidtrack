#!/bin/bash
# Skrypt do walidacji wszystkich plików XSD w repozytorium
set -e

XSD_DIRS=(schemas/xsd)

for dir in "${XSD_DIRS[@]}"; do
  for file in $dir/*.xsd; do
    echo "Waliduję: $file"
    xmllint --noout --schema "$file" "$file" || { echo "Błąd walidacji: $file"; exit 1; }
  done
done

echo "Wszystkie schematy XSD są poprawne."
