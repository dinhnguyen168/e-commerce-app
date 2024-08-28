package com.codewithdinh.ecommerce.order.application.dto;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
