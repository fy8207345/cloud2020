package com.fy.springcloud.consumer.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
@RequestMapping("/payment")
public interface PaymentHystrixService {

    @GetMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Long id);

    @GetMapping("/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Long id);
}
