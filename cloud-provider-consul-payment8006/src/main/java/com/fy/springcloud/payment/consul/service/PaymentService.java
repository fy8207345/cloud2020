package com.fy.springcloud.payment.consul.service;

import com.fy.springcloud.entity.Payment;

public interface PaymentService {

    Integer create(Payment payment);

    Payment getPaymentById(Long id);
}
