package com.fy.springcloud.payment.consul.dao;

import com.fy.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    Integer create(Payment payment);

    Payment getPaymentById(Long id);

}
