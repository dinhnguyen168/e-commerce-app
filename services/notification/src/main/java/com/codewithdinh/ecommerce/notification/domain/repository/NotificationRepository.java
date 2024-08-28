package com.codewithdinh.ecommerce.notification.domain.repository;

import com.codewithdinh.ecommerce.notification.domain.model.notification.Notification;

import java.util.List;

public interface NotificationRepository {
    Notification saveNotificationIntoDatabase(Notification notification);

    List<Notification> getAllNotifications();
}
