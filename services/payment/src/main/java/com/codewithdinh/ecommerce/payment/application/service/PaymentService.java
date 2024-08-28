package com.codewithdinh.ecommerce.payment.application.service;

import com.codewithdinh.ecommerce.payment.application.dto.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentService {
    Integer createPayment(PaymentRequest request) throws JsonProcessingException;
}
