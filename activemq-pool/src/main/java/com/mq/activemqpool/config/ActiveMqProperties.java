package com.mq.activemqpool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Component
@PropertySource(value = {"classpath:activemqConfig.properties"})
@ConfigurationProperties(prefix = "activemq")
@Validated
public class ActiveMqProperties {
    private String topic;
    private String queue;
    @Email
    private String email;

    @Override
    public String toString() {
        return "ActiveMqProperties{" +
                "topic='" + topic + '\'' +
                ", queue='" + queue + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
