package com.fy.springcloud.payment.service;

import com.fy.springcloud.payment.entity.Payment;

public interface PaymentService {

    Integer create(Payment payment);

    Payment getPaymentById(Long id);
}
