package com.codewithdinh.ecommerce.customer.application.dto;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
