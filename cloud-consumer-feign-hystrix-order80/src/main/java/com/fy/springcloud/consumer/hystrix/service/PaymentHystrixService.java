package com.fy.springcloud.consumer.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Long id);

    @GetMapping("/payment/circuit/{id}")
    public String circuit(@PathVariable("id") Long id);
}
