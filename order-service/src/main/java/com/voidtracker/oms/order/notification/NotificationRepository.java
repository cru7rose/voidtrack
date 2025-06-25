package com.voidtracker.oms.order.notification;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class NotificationRepository {
    private final Map<String, NotificationDto> notifications = new HashMap<>();

    public void save(NotificationDto notification) { notifications.put(notification.getId(), notification); }
    public Optional<NotificationDto> findById(String id) { return Optional.ofNullable(notifications.get(id)); }
    public List<NotificationDto> findAll() { return new ArrayList<>(notifications.values()); }
}
