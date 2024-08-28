package com.codewithdinh.ecommerce.notification.application.service;

import com.codewithdinh.ecommerce.notification.application.dto.NotificationResponse;
import com.codewithdinh.ecommerce.notification.application.mapper.NotificationMapper;
import com.codewithdinh.ecommerce.notification.domain.model.notification.Notification;
import com.codewithdinh.ecommerce.notification.domain.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repository;
    private final NotificationMapper mapper;

    @Override
    public List<NotificationResponse> getAllNotifications() {
        List<Notification> notifications = repository.getAllNotifications();
        return mapper.toNotificationResponse(notifications);
    }
}
