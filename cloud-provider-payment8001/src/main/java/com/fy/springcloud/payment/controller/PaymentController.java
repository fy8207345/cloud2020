package com.fy.springcloud.payment.controller;

import com.fy.springcloud.payment.entity.CommonResult;
import com.fy.springcloud.payment.entity.Payment;
import com.fy.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(Payment payment){
        Integer result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if(result > 0){
            return new CommonResult(200, "成功");
        }
        return new CommonResult(0, "失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult<Payment>(200, "成功", payment);
        }
        return new CommonResult<>(0, "失败");
    }
}
