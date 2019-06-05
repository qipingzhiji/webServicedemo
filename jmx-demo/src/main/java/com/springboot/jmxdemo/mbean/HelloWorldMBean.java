package com.springboot.jmxdemo.mbean;

public interface HelloWorldMBean {
    String getGreeting();
    void setGreeting(String greeting);
    void printGreeting();
}
