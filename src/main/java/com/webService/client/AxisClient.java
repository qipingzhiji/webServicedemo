package com.webService.client;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class AxisClient {
    public static void main(String[] args) throws  Exception{
        //参数：代表的是webservice请求服务端地址的一部分。
        EndpointReference  targetERP = new EndpointReference("http://localhost:8080/services/ZipKinService");
        RPCServiceClient client = new RPCServiceClient();
        Options options = client.getOptions();
        //参数：代表设置超时时间为20秒
        options.setTimeOutInMilliSeconds(2 * 20000L);
        options.setTo(targetERP);
        //参数1代表：在网页上执行 wsdl后xs:schema标签的targetNamespace路径 例如： <xs:schema  targetNamespace="http://axis2.com">
        //参数2代表： 2：<xs:element name="test"> ======这个标签中name的值
        QName qName = new QName("http://webService.com", "test");
        //请求服务端方法的入参
        String str = "我是客户端";
        Object[] param = new Object[]{str};
        //服务端返回出参
        Class<?>[] types = new Class[]{String.class};
        /**
         * RPCServiceClient类的invokeBlocking方法调用了WebService中的方法。
         * invokeBlocking方法有三个参数
         * 第一个参数的类型是QName对象，表示要调用的方法名；
         * 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
         * 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
         * 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}。
         */
        Object[] response = client.invokeBlocking(qName, param, types);
        System.out.println(response[0]);
    }
}
