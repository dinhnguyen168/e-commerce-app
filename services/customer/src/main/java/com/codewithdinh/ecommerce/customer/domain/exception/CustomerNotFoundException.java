package com.codewithdinh.ecommerce.customer.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomerNotFoundException extends RuntimeException {
    private final String message;
}
