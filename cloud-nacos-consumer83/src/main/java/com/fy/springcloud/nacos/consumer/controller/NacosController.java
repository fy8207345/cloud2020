package com.fy.springcloud.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/nacos/{string}")
    public String nacos(@PathVariable String string){
        return restTemplate.getForObject(url + "/nacos/" + string, String.class);
    }
}
