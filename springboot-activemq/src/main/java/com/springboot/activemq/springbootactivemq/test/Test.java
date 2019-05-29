package com.springboot.activemq.springbootactivemq.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str1 = "admin";
        String str2 = "zhangsan";
        String[] arrays = new String[]{str1,str2};
        Arrays.asList(arrays).forEach(s -> {
            System.out.println(s);
        });
    }
}
