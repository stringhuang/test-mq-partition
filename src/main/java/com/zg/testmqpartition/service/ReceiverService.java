package com.zg.testmqpartition.service;

import com.zg.testmqpartition.channel.InboundChannel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Log4j2
@EnableBinding(value = InboundChannel.class)
@Service
public class ReceiverService {

    @Value("${server.port}")
    private String port;

    @StreamListener(InboundChannel.INBOUND_CHANNEL_NAME)
    public void receiveMsg(Message<String> msg) {
        log.info("ReceiverClass in Instance {}  has received message: {}", this.port, msg.getPayload());
    }
}
