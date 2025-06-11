package com.voidtracker.oms.commons.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object dla Elektronicznego Potwierdzenia Odbioru (ePoD).
 * Używany do przesyłania danych ePoD z aplikacji mobilnej do backendu.
 */
@Data
@NoArgsConstructor
public class EPodDto {
    private String epodId;
    private String orderId;
    private String timestamp;
    private String userId;
    private String signature; // base64/png
    private List<String> photos; // base64/png lub URL
    private LocationDto location;
    private String note;

    @Data
    @NoArgsConstructor
    public static class LocationDto {
        private Double lat;
        private Double lng;
    }
}