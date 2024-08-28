package com.codewithdinh.ecommerce.product.domain.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class ProductNotFoundException extends RuntimeException {
    private final String message;
}
