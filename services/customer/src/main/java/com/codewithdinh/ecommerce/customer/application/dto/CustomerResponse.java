package com.codewithdinh.ecommerce.customer.application.dto;

import com.codewithdinh.ecommerce.customer.domain.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse(
        String id,
        @NotNull(message = "Customer firstname is required")
        String firstName,
        @NotNull(message = "Customer lastname is required")
        String lastName,
        @NotNull(message = "Customer email is required")
        @Email(message = "Customer email is invalid")
        String email,
        Address address
) {
}
