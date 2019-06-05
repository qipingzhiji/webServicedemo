package com.springboot.jmxdemo.mbean;

public class HelloWorld implements HelloWorldMBean {

    private String greeting;

    @Override
    public String getGreeting() {
        return greeting;
    }

    @Override
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void printGreeting() {
        System.out.println(greeting);
    }
}
