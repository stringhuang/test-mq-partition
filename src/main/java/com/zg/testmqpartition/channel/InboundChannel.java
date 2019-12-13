package com.zg.testmqpartition.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InboundChannel {
    /**
     * 通道名称
     */
    String INBOUND_CHANNEL_NAME = "inputChannel";

    @Input(value = InboundChannel.INBOUND_CHANNEL_NAME)
    SubscribableChannel input();
}
