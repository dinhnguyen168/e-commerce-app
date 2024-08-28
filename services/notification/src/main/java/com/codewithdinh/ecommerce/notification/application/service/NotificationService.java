package com.codewithdinh.ecommerce.notification.application.service;

import com.codewithdinh.ecommerce.notification.application.dto.NotificationResponse;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getAllNotifications();
}
