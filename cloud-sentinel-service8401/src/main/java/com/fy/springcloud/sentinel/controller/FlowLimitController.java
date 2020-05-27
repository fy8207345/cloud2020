package com.fy.springcloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/hot")
    @SentinelResource(value = "hot", blockHandler = "hot_Handler")
    public String hot(@RequestParam(value = "p1", required = false) String p1,
                      @RequestParam(value = "p2", required = false) String p2){
        return "hot";
    }

    public String hot_Handler(String p1, String p2, BlockException e){
        return "hot_Handler:" + e.getMessage();
    }
}
