package com.springboot.jmxdemo.test;

public class Test {
    public static void main(String[] args) {
        parse(9);
    }


    public static void parse(int i) {
        parse_endponint:
        while(i<10) {
            switch (i) {
                case 1:
                    System.out.println(i);
                    i++;
                    break parse_endponint;
                case 2:
                    System.out.println(i);
                    break;
                case 9:
                    i =1;
                    System.out.println(i);
                    break parse_endponint;
                default:
                    break ;

            }
        }
    }
}
