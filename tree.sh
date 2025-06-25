(
  echo "--- STRUKTURA PROJEKTU (tylko istotne pliki) ---"
  find . -type d \( -name ".idea" -o -name ".mvn" -o -name "target" \) -prune -o -type f \( -name "*.java" -o -name "*.xml" -o -name "*.yml" -o -name "*.properties" -o -name "*.md" -o -name "*gitkeep" \) -print

  echo -e "\n\n--- ZAWARTOŚĆ PLIKÓW ŹRÓDŁOWYCH I KONFIGURACYJNYCH ---"
  find . -type d \( -name ".idea" -o -name ".mvn" -o -name "target" \) -prune -o -type f \( -name "*.java" -o -name "*.xml" -o -name "*.yml" -o -name "*.properties" -o -name "*.md" -o -name "*gitkeep" \) -exec sh -c 'echo -e "\n\n--- Plik: {} ---"; cat "{}"' \;
) > raport_inteligentny.txt