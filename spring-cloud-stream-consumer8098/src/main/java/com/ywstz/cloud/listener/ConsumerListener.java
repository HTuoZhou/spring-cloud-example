package com.ywstz.cloud.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author TuoZhou
 */
// 定义消息的接收管道
@EnableBinding(Sink.class)
public class ConsumerListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者接受到的消息: " + message.getPayload() + " serverPort: " + serverPort);
    }
}

