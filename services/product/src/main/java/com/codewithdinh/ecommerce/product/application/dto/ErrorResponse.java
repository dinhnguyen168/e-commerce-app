package com.codewithdinh.ecommerce.product.application.dto;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
