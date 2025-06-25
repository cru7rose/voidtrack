package com.voidtracker.oms.order.tracking;

import lombok.Data;

@Data
public class TrackingEventDto {
    private String eventId;
    private String orderId;
    private String vehicleId;
    private String driverId;
    private String eventType; // e.g., GPS_UPDATE, STATUS_CHANGE
    private double latitude;
    private double longitude;
    private String timestamp;
}
