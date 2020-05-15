package com.fy.springcloud.stream.rabbit.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableBinding(Sink.class)
public class MessageConsumerController {

    @Value("${server.port}")
    private Integer port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("{} received message : {} ", port, message.getPayload());
    }
}
