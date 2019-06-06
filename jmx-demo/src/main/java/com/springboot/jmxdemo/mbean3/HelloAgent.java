package com.springboot.jmxdemo.mbean3;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class HelloAgent {
    public static void main(String[] args) throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("demo:name=hello");
        Hello hello = new Hello();
        mBeanServer.registerMBean(hello, objectName);
        Jack jacK = new Jack();
        mBeanServer.registerMBean(jacK, new ObjectName("jack:name=jack"));
        jacK.addNotificationListener(new HelloListener(),null,hello);
        Thread.sleep(60*60*1000);
    }
}
