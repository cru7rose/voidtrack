package com.voidtracker.oms.order.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationServiceImpl extends NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    // TODO: Implement notification sending, alerting, and persistence logic
    public void sendNotification(NotificationDto notification) {
        notificationRepository.save(notification);
        // TODO: Integrate with email/SMS/push/etc.
    }

    public List<NotificationDto> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
