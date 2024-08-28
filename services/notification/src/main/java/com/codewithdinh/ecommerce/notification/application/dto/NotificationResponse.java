package com.codewithdinh.ecommerce.notification.application.dto;

import com.codewithdinh.ecommerce.notification.domain.model.notification.NotificationType;
import com.codewithdinh.ecommerce.notification.domain.model.order.OrderConfirmation;
import com.codewithdinh.ecommerce.notification.domain.model.payment.PaymentConfirmation;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NotificationResponse(
        NotificationType notificationType,
        LocalDateTime notificationDate,
        OrderConfirmation orderConfirmation,
        PaymentConfirmation paymentConfirmation
) {
}
