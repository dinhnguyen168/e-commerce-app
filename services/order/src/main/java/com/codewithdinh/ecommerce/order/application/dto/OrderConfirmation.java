package com.codewithdinh.ecommerce.order.application.dto;

import com.codewithdinh.ecommerce.order.domain.model.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
