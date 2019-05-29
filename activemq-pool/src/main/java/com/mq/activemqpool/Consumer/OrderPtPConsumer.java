package com.mq.activemqpool.Consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderPtPConsumer {

    @JmsListener(destination = "common.queue")
    public void receiveQueue(String text) throws Exception{
        Thread.sleep(100000);
        System.out.println("111");
        System.out.println("OrderConsumer收到的报文为OrderConsume:"+text);
    }
}
