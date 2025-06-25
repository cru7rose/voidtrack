package com.voidtracker.oms.order.notification;

import lombok.Data;

@Data
public class NotificationDto {
    private String id;
    private String type; // e.g., ALERT, INFO, WARNING
    private String message;
    private String recipient;
    private String sentAt;
}
