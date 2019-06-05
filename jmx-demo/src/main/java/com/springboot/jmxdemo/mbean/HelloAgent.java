package com.springboot.jmxdemo.mbean;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;

public class HelloAgent implements NotificationListener {

    private MBeanServer server;


    public void helloAgent() {
        this.server = MBeanServerFactory.createMBeanServer("helloAgent");
        HelloWorld helloWorld = new HelloWorld();
        ObjectName helloWorldName = null;
        try {
            helloWorldName = new ObjectName("helloAgent:name=helloWorld");
            server.registerMBean(helloWorld,helloWorldName);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleNotification(Notification notification, Object handback) {

    }

    public void startHtmlAdaptorServer() {
        HtmlAdaptorServer htmlAdaptorServer = new HtmlAdaptorServer();
        ObjectName adapterName = null;
        try {
            adapterName = new ObjectName("helloAgent:name=htmladaptor,port=9092");
            htmlAdaptorServer.setPort(9092);
            server.registerMBean(htmlAdaptorServer,adapterName);
            htmlAdaptorServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HelloAgent helloAgent = new HelloAgent();
        helloAgent.helloAgent();
        helloAgent.startHtmlAdaptorServer();
    }
}
