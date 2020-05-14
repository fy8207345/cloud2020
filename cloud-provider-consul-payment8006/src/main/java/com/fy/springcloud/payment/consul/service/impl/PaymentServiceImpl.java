package com.fy.springcloud.payment.consul.service.impl;

import com.fy.springcloud.entity.Payment;
import com.fy.springcloud.payment.consul.dao.PaymentDao;
import com.fy.springcloud.payment.consul.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Integer create(Payment payment) {
        System.out.println("create called :" + payment);
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
