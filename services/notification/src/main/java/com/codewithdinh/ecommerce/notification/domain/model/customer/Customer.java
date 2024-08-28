package com.codewithdinh.ecommerce.notification.domain.model.customer;

public record Customer(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
