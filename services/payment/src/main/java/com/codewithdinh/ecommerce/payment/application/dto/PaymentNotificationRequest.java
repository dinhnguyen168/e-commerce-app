package com.codewithdinh.ecommerce.payment.application.dto;

import com.codewithdinh.ecommerce.payment.domain.model.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
