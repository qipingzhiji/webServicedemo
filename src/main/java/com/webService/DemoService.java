package com.webService;

public class DemoService {
    public String test(String param) {
        System.out.println("DemoService#test执行了......");
        return "请求参数为：" + param;
    }
}
