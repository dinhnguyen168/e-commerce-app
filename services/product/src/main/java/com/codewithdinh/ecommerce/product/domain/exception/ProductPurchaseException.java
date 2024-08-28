package com.codewithdinh.ecommerce.product.domain.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class ProductPurchaseException extends RuntimeException {
    private final String message;
}
