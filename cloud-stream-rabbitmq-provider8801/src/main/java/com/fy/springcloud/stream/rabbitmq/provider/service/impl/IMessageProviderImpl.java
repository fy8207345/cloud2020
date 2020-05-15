package com.fy.springcloud.stream.rabbitmq.provider.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@EnableBinding(Source.class)
public class IMessageProviderImpl implements com.fy.springcloud.stream.rabbitmq.provider.service.IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        log.info("Sending message : {}", message);
        return "message sent!" + message;
    }
}
