package com.fy.springcloud.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @GetMapping("/nacos/{string}")
    public String nacos(@PathVariable String string){
        return "hello, nacos" + string;
    }
}
