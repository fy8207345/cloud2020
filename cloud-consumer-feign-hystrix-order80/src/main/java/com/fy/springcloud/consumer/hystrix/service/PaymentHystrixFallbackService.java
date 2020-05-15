package com.fy.springcloud.consumer.hystrix.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService{

    @Override
    public String ok(Long id) {
        return "PaymentHystrixFallbackService ok!";
    }

    @Override
    public String timeout(Long id) {
        return "PaymentHystrixFallbackService timeout!";
    }

    @Override
    public String circuit(Long id) {
        return "PaymentHystrixFallbackService circuit!";
    }
}
