package com.fy.springcloud.consumer.feign.service;

import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {

    @GetMapping("/get/{id}")
    CommonResult<Payment> get(@PathVariable("id") Long id);

    @GetMapping("/feignTimeout")
    public String feignTimeout();
}
