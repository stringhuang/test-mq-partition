package com.zg.testmqpartition.service;

import com.zg.testmqpartition.channel.InboundChannel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Log4j2
@EnableBinding(value = InboundChannel.class)
@Service
public class ReceiverService {

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            8,
            16,
            1000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @Value("${server.port}")
    private String port;

    @StreamListener(InboundChannel.INBOUND_CHANNEL_NAME)
    public void receiveMsg(Message<String> msg) throws Exception {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                long sleepSeconds = Double.valueOf(Math.random() * 10000).longValue();
                try {
                    Thread.sleep(sleepSeconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("ReceiverClass in Instance {}  has received message: {}, and sleep {} millis", port, msg.getPayload(), sleepSeconds);
            }
        });
    }
}
