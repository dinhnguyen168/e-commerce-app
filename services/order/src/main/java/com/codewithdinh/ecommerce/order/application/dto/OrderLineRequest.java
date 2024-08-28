package com.codewithdinh.ecommerce.order.application.dto;

import lombok.Builder;

@Builder
public record OrderLineRequest(
    Integer id,
    Integer orderId,
    Integer productId,
    double quantity
) {}
