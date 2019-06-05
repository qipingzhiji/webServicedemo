package com.springboot.jmxdemo.mbean2;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class ClientAgent {

    public static void main(String[] args) throws Exception {
        jconsoleAgent();
    }

    /**
     * htmlAdaptor
     * @throws MalformedObjectNameException
     * @throws InstanceAlreadyExistsException
     * @throws MBeanRegistrationException
     * @throws NotCompliantMBeanException
     */
    private static void htmlAgent() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        server.registerMBean(new Hello(), helloName);
        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);
        adapter.start();
    }

    /**
     * jconsole连接
     * @throws Exception
     */
    private static void jconsoleAgent() throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxbean:name=hello");
        server.registerMBean(new Hello(), helloName);
        Thread.sleep(60*60*1000);
    }
}
