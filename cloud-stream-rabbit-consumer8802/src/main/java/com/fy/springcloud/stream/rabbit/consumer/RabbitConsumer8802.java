package com.fy.springcloud.stream.rabbit.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitConsumer8802 {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumer8802.class, args);
    }

}