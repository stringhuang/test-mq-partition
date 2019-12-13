package com.zg.testmqpartition.service;

import com.zg.testmqpartition.channel.OutboundChannel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@EnableBinding(OutboundChannel.class)
public class SenderService {

    @Autowired
    private OutboundChannel outboundChannel;

    public Boolean sendMsg(String msg) {
        MessageHeaders messageHeaders = new MessageHeaders(null);
        Message<String> message = MessageBuilder.createMessage(msg, messageHeaders);
        log.info("SenderService has sent message: {}", msg);
        return this.outboundChannel.getOutbuondChannel().send(message);
    }
}
