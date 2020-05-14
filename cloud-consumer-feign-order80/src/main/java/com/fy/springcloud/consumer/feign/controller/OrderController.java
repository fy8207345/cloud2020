package com.fy.springcloud.consumer.feign.controller;

import com.fy.springcloud.consumer.feign.service.PaymentFeignService;
import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.get(id);
    }

    @GetMapping("/feignTimeout")
    public String feignTimeout(){
        return paymentFeignService.feignTimeout();
    }
}
