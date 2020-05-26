package com.fy.springcloud.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/flowA")
    public String flowA() {
        try {
            Thread.sleep(800);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "flowA";
    }

    @GetMapping("/flowB")
    public String flowB(){
        return "flowB";
    }
}