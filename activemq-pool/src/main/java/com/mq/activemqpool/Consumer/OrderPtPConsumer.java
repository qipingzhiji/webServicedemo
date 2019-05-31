package com.mq.activemqpool.Consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPtPConsumer {

    @JmsListener(destination = "common.queue", containerFactory = "jmsListenerQueue")
    public void receiveQueue(String text) {
        System.out.println("OrderConsumer收到的报文为OrderConsume:"+text);
    }
}
