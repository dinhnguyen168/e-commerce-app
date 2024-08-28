package com.codewithdinh.ecommerce.payment.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
public record CustomerDTO(
        String id,

        @NotNull(message = "Firstname is required")
        String firstname,

        @NotNull(message = "Lastname is required")
        String lastname,

        @NotNull(message = "Email is required")
        @Email(message = "The customer email is not correctly formatted")
        String email
) {
}
