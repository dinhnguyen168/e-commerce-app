package com.codewithdinh.ecommerce.payment.domain.repository;

import com.codewithdinh.ecommerce.payment.domain.model.Payment;

public interface PaymentRepository {
    Payment savePaymentIntoDatabase(Payment payment);
}
