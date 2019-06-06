package com.springboot.jmxdemo.mbean2;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

public class ClientAgent {

    public static void main(String[] args) throws Exception {
        remoteAgent();
    }

    /**
     * htmlAdaptor
     *
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
     *
     * @throws Exception
     */
    private static void jconsoleAgent() throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxbean:name=hello");
        server.registerMBean(new Hello(), helloName);
        Thread.sleep(60 * 60 * 1000);
    }

    /**
     * 进行远程客户端的访问
     *
     * @throws Exception
     */
    private static void remoteAgent() throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName objectName = new ObjectName("mbeanserver:name=hello");
        server.registerMBean(new Hello(), objectName);
        LocateRegistry.createRegistry(9999);
        JMXServiceURL url = new JMXServiceURL("services:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnectorServer jmxConnectorServer = JMXConnectorServerFactory.newJMXConnectorServer(url,null,server);
        System.out.println("begin rmi start");
        jmxConnectorServer.start();
        System.out.println("rmi start");
    }
}
