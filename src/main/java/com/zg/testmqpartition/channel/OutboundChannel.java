package com.zg.testmqpartition.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface OutboundChannel {

    /**
     * 通道名称
     */
    String OUT_BOUNT_CHANNEL_NAME = "outputChannel";

    @Output(value = OutboundChannel.OUT_BOUNT_CHANNEL_NAME)
    MessageChannel getOutbuondChannel();
}
