package com.mq.activemqpool.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class ActiveMqConfig {

    @Autowired
    private ActiveMqProperties activeMqProperties;

    //消息队列的发布订阅模式
    @Bean(name = "topic")
    public Topic topic()  {
        return new ActiveMQTopic(activeMqProperties.getTopic());
    }

    //消息队列的点对点模式
    @Bean(name = "queue")
    public Queue queue() {
        return new ActiveMQQueue(activeMqProperties.getQueue());
    }
    //这种方式开启的是mq中的点对点模式的消息传递
    @Bean(name = "jmsListenerQueue")
    public  JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        return jmsListenerContainerFactory;
    }

    //自定义同时开启pub_sub和点对点模式，因为activemq默认只支持一种模式
    @Bean(name = "jmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory  bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

}
