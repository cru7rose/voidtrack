package com.voidtracker.oms.order.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/notifications")
public class NotificationControllerV2 {
    @Autowired
    private NotificationServiceImpl notificationService;

    @GetMapping
    public List<NotificationDto> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}
