package com.fy.springcloud.stream.rabbit.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitConsumer8803 {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumer8803.class, args);
    }

}