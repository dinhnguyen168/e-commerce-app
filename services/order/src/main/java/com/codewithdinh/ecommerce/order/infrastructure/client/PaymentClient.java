package com.codewithdinh.ecommerce.order.infrastructure.client;

import com.codewithdinh.ecommerce.order.application.dto.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    Integer requestPayment(@RequestBody PaymentRequest payment) throws JsonProcessingException;
}
