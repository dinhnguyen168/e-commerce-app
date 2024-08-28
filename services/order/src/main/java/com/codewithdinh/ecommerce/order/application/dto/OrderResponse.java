package com.codewithdinh.ecommerce.order.application.dto;

import com.codewithdinh.ecommerce.order.domain.model.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
