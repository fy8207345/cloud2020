package com.fy.springcloud.order.nacos.feign;

import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import com.fy.springcloud.order.nacos.feign.fallback.PaymentServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-nacos-provider-payment", fallback = PaymentServiceFallbackImpl.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id);
}
