package com.activemq.demo;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

//消息消费者
public class Comsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    ConnectionFactory connectionFactory;

    Connection connection;

    Session session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<MessageConsumer>();
    AtomicInteger count = new AtomicInteger();

    //链接工厂初始化
    public void init() throws  Exception{
        //创建链接工厂
        connectionFactory  = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEN_URL);
        //创建链接
        connection = connectionFactory.createConnection();
        //开启链接
        connection.start();
        //开启会话
        session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
    }

    //获取生产者发出的消息
    public void receiveMessage(String queueName) throws  Exception{
        //拿到队列
        Queue queue = session.createQueue(queueName);
        MessageConsumer messageConsumer = null;
        if(threadLocal.get() != null ) {
            messageConsumer = threadLocal.get();
        } else {
            messageConsumer = session.createConsumer(queue);
        }

        while (true) {
            Thread.sleep(1000);
            TextMessage receiveMessage = (TextMessage)messageConsumer.receive();
            if (receiveMessage == null) {
                break;
            } else {
                //消息应答
                receiveMessage.acknowledge();
                System.out.println(Thread.currentThread().getName() + "我是消费者，我正在消费消息: " + receiveMessage.getText());
            }
        }
    }
}
