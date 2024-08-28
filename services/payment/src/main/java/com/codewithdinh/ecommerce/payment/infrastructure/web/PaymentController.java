package com.codewithdinh.ecommerce.payment.infrastructure.web;

import com.codewithdinh.ecommerce.payment.application.dto.PaymentRequest;
import com.codewithdinh.ecommerce.payment.application.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer createPayment(@RequestBody PaymentRequest payment) throws JsonProcessingException {
        return service.createPayment(payment);
    }
}
