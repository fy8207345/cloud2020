package com.fy.springcloud.payment.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    public String paymentInfo_OK(Long id){
        return "线程池：" + id + ", " + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    public String paymentInfo_Timeout(Long id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + id + ", " + Thread.currentThread().getName() + ", 耗时三秒";
    }

    public String paymentInfo_TimeoutHandler(Long id){
        return "线程池：" + id + ", " + Thread.currentThread().getName() + ", PaymentService.paymentInfo_TimeoutHandler";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(Long id){
        if(id < 0){
            throw new RuntimeException("***id不能小于0！");
        }
        return "paymentCircuitBreaker***" + Thread.currentThread().getName() + ":" + UUID.randomUUID().toString();
    }

    public String paymentCircuitBreaker_Fallback(Long id){
        return "paymentCircuitBreaker_Fallback***" + Thread.currentThread().getName() + ":" + UUID.randomUUID().toString();
    }
}
