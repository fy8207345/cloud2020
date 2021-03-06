package com.fy.springcloud.payment.hystrix.controller;

import com.fy.springcloud.payment.hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("****ok result: {}", result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("****timeout result: {}", result);
        return result;
    }

    @GetMapping("/circuit/{id}")
    public String circuit(@PathVariable("id") Long id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****timeout result: {}", result);
        return result;
    }
}
