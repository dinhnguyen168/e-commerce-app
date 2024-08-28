package com.codewithdinh.ecommerce.order.application.dto;

import lombok.Builder;

@Builder
public record OrderLineResponse(
        Integer id,
        double quantity
) {
}
