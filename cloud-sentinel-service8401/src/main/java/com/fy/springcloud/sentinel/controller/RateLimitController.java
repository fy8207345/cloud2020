package com.fy.springcloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerbyResource")
    public CommonResult byResource(){
        return new CommonResult(200, "byResource限流", new Payment(201L, "paymentSerial-byResource"));
    }

    public CommonResult handlerbyResource(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + " 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource("byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "byUrl限流", new Payment(202L, "paymentSerial-byUrl"));
    }
}
