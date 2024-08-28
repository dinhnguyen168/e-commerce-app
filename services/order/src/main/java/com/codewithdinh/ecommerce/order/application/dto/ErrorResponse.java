package com.codewithdinh.ecommerce.order.application.dto;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
