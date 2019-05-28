package com.activemq.demo;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Producter {
    //ActiveMq 的默认用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq 的默认登录密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMQ 的链接地址
    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    AtomicInteger count = new AtomicInteger(0);
    //链接工厂
    ConnectionFactory connectionFactory;
    //链接对象
    Connection connection;
    //事务管理
    Session session;

    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<MessageProducer>();

    //初始链接工厂
    public void init() throws Exception{
        //创建链接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD, BROKEN_URL);
        //获得链接
        connection = connectionFactory.createConnection();
        //开启链接
        connection.start();
        //开启事务
        session =  connection.createSession(true, Session.SESSION_TRANSACTED);
    }

    //发送消息
    public void sendMessage(String queueName) throws  Exception{
        int i = 0;
        //消息队列
        Queue queue = session.createQueue(queueName);
        //消息生产者
        MessageProducer messageProducer = null;
        if(threadLocal.get() != null) {
            messageProducer = threadLocal.get();
        } else {
            messageProducer = session.createProducer(queue);
        }

        while(true)  {
            Thread.sleep(1000);
            int num = count.getAndIncrement();
            TextMessage textMessage = session.createTextMessage(Thread.currentThread().getName() + "Productor: 我是生产者，我正在生产消息");
            //发送消息
            messageProducer.send(textMessage);
            System.out.println(textMessage.getText());
            //提交事务
            session.commit();
            i++;
            if(i > 2) {
                return;
            }
        }


    }


}
