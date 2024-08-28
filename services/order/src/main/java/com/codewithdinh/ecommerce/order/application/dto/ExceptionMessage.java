package com.codewithdinh.ecommerce.order.application.dto;

import lombok.Builder;

@Builder
public record ExceptionMessage(String errorMessage) {
}
