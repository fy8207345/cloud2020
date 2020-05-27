package com.fy.springcloud.nacos.controller;

import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        Payment payment = new Payment(id, "payment " + id);
        if(id > 3){
            payment = null;
        }
        return new CommonResult<Payment>(200,"payment from :" + port, payment);
    }
}
