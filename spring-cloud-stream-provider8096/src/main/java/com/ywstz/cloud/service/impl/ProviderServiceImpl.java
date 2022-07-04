package com.ywstz.cloud.service.impl;

import com.ywstz.cloud.service.IProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author TuoZhou
 */
// 定义消息的推送管道
@EnableBinding(Source.class)
public class ProviderServiceImpl implements IProviderService {

    private final MessageChannel output;

    public ProviderServiceImpl(MessageChannel output) {
        this.output = output;
    }

    @Override
    public String sendMessage() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        return serial;
    }
}
