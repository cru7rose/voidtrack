// Plik: voidtracker-commons/src/main/java/com/voidtracker/oms/commons/enums/OrderStatus.java
package com.voidtracker.oms.commons.enums;

/**
 * Definiuje statusy cyklu życia zlecenia, zgodnie z dokumentacją projektową.
 * Te statusy są kluczowe dla logiki biznesowej w całym systemie.
 */
public enum OrderStatus {
    /**
     * Zlecenie utworzone, oczekuje na weryfikację (np. poprawności adresu).
     */
    PENDING,

    /**
     * Zlecenie zweryfikowane i gotowe do przydziału kierowcy.
     */
    NEW,

    /**
     * Zlecenie w trakcie odbioru od nadawcy.
     */
    PICKUP,

    /**
     * Paczka w sortowni lub w trakcie transferu między oddziałami.
     */
    TERM,

    /**
     * Paczka załadowana na samochód dostawczy.
     */
    LOAD,

    /**
     * Zlecenie dostarczone, uzyskano elektroniczne potwierdzenie odbioru (ePoD).
     */
    POD
}