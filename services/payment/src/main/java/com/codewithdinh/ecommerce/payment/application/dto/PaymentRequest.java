package com.codewithdinh.ecommerce.payment.application.dto;

import com.codewithdinh.ecommerce.payment.domain.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    Integer id,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerDTO customer
) {
}
