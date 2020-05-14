package com.fy.springcloud.payment.controller;

import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import com.fy.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(Payment payment){
        Integer result = paymentService.create(payment);
        if(result > 0){
            return new CommonResult(200, "成功");
        }
        return new CommonResult(0, "失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("calling server port : {}", serverPort);
        if(payment != null){
            return new CommonResult<Payment>(200, "成功:"+serverPort, payment);
        }
        return new CommonResult<>(0, "失败"+serverPort);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String s : services){
            log.info("****service: {} ", s);
        }

        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : list){
            log.info("****instance: {} ", instance.getInstanceId());
        }
        return discoveryClient;
    }

    @GetMapping("/feignTimeout")
    public String feignTimeout(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "feignTimeout : " + serverPort;
    }
}
