package com.fy.springcloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/nacos/{string}")
    public String nacos(@PathVariable String string){
        return  port + " - hello, nacos" + string;
    }
}
