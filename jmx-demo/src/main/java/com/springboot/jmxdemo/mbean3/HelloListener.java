package com.springboot.jmxdemo.mbean3;

import com.springboot.jmxdemo.mbean3.Hello;

import javax.management.Notification;
import javax.management.NotificationListener;

public class HelloListener implements NotificationListener {
    @Override
    public void handleNotification(Notification notification, Object handback) {
        if(handback instanceof Hello){
            Hello hello = (Hello) handback;
            hello.printHello(notification.getMessage());
        }
    }
}
