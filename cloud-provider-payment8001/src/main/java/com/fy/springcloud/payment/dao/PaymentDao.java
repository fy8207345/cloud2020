package com.fy.springcloud.payment.dao;

import com.fy.springcloud.payment.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    Integer create(Payment payment);

    Payment getPaymentById(Long id);

}
