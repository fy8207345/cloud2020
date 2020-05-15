package com.fy.springcloud.stream.rabbitmq.provider.controller;

import com.fy.springcloud.stream.rabbitmq.provider.service.IMessageProvider;
import org.aspectj.bridge.IMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageProviderController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send(){
        return messageProvider.send();
    }
}
