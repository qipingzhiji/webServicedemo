package com.mq.activemqpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Topic;

//生产者生产消息
@Service
public class ProcedureServiceImpl {

    //用来把消息发送到broker的对象
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;
    /**
     *
     * @param destination 发送消息的队列
     * @param message 要发送给brokel对象的消息
     */
    public void sendMessage(Destination destination, String message) {
        System.out.println("发送的报文主体为：" + message);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    public void publish(String msg) {
        System.out.println("发送的报文消息主体为：" + msg);
        jmsMessagingTemplate.convertAndSend(topic, msg);
    }


}
