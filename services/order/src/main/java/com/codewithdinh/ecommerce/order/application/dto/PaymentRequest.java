package com.codewithdinh.ecommerce.order.application.dto;


import com.codewithdinh.ecommerce.order.domain.model.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PaymentRequest(
    Integer id,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
