package com.fy.springcloud.order.consul.controller;

import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001/payment";
    //consul
    private static final String PAYMENT_URL = "http://cloud-payment-service/payment";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create/payment")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/get/" + id, CommonResult.class);
    }

    @GetMapping("/discovery")
    public Object getDiscovery(){
        return restTemplate.getForObject(PAYMENT_URL + "/discovery", Object.class);
    }

    @GetMapping("/consul")
    public Object consul(){
        return restTemplate.getForObject(PAYMENT_URL + "/consul", String.class);
    }
}
