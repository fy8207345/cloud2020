package com.fy.springcloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosServer9001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosServer9001.class, args);
    }

}