package com.fy.springcloud.order.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import com.fy.springcloud.order.nacos.feign.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    private static final String URL = "http://cloud-nacos-provider-payment";

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private PaymentService paymentService;

    @GetMapping("/order/{id}")
//    @SentinelResource(value = "order")
//    @SentinelResource(value = "order", fallback = "fallbackHandler")
//    @SentinelResource(value = "order", blockHandler = "blockHandler")
    @SentinelResource(value = "order", blockHandler = "blockHandler", fallback = "fallbackHandler",
    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult order(@PathVariable("id") Long id){
        CommonResult<Payment> commonResult = restTemplate.getForObject(URL + "/payment/" + id, CommonResult.class);
//        CommonResult<Payment> commonResult = paymentService.get(id);
        if(id == 4){
            throw new IllegalArgumentException("无效参数：" + id);
        }else if(commonResult.getData() == null){
            throw new NullPointerException("无记录："+id);
        }
        return commonResult;
    }

    @GetMapping("/feign/order/{id}")
    public CommonResult feignOrder(@PathVariable("id") Long id){
        return paymentService.get(id);
    }

    public CommonResult fallbackHandler(Long id, Throwable e){
        return new CommonResult(444, id + ":" + e.getMessage());
    }

    public CommonResult blockHandler(Long id, BlockException e){
        return new CommonResult(555, id + ":" + e.getMessage());
    }
}
