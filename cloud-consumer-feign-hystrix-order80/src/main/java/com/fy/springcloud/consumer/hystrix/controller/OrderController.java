package com.fy.springcloud.consumer.hystrix.controller;

import com.fy.springcloud.consumer.hystrix.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/hystrix")
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String ok(@PathVariable("id") Long id){
        return paymentHystrixService.ok(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="3000")
//    })
    @HystrixCommand
    @GetMapping("/timeout/{id}")
    public String timeout(@PathVariable("id") Long id){
        return paymentHystrixService.timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Long id){
        return "线程池：" + id + ", " + Thread.currentThread().getName() + ", OrderController.paymentInfo_TimeoutHandler";
    }

    public String globalFallback(){
        return "GlobalFallback!!!";
    }
}
