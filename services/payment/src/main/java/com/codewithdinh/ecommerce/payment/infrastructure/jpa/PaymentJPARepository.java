package com.codewithdinh.ecommerce.payment.infrastructure.jpa;

import com.codewithdinh.ecommerce.payment.domain.model.Payment;
import com.codewithdinh.ecommerce.payment.domain.repository.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJPARepository extends JpaRepository<Payment, Integer>, PaymentRepository {
    default Payment savePaymentIntoDatabase(Payment payment) {
        return save(payment);
    }
}
