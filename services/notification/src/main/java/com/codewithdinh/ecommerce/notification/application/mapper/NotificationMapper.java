package com.codewithdinh.ecommerce.notification.application.mapper;

import com.codewithdinh.ecommerce.notification.application.dto.NotificationResponse;
import com.codewithdinh.ecommerce.notification.domain.model.notification.Notification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationMapper {

    public List<NotificationResponse> toNotificationResponse(List<Notification> notifications) {
        return notifications.stream().map(
                notification -> NotificationResponse.builder()
                        .notificationType(notification.getNotificationType())
                        .notificationDate(notification.getNotificationDate())
                        .orderConfirmation(notification.getOrderConfirmation())
                        .paymentConfirmation(notification.getPaymentConfirmation())
                        .build()
        ).toList();
    }
}
