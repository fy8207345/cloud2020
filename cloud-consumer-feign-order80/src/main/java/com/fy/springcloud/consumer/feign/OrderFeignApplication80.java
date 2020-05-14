package com.fy.springcloud.consumer.feign;

import com.fy.springcloud.ribbon.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRule.class)
public class OrderFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication80.class, args);
    }
}
