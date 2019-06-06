package com.java8.function;

import jdk.nashorn.internal.ir.FunctionCall;

import java.util.function.Function;

public class Test4 {
    public static void main(String[] args) {
        Function f = o->{
            System.out.println(o);return o;};
        f.apply(20);
    }
}

