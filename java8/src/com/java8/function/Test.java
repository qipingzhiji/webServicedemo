package com.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("输出所有的数据");
        eavl(list, n->true);
        System.out.println("输出所有的偶数;");
        eavl(list, n->n%2==0);
        System.out.println("输出所有大于3的数字:");
        eavl(list, n-> n>3);


        System.out.println("---------------------------------------------------------------------");

        System.out.println("输出大于3并且是偶数的数字：");
        eavlAnd(list,n->n>3,n->n%2==0);

    }

    public static void eavl(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if(predicate.test(integer)) {
                System.out.println(integer+ " ");
            }
        }
    }

    public static void eavlAnd(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if(predicate1.and(predicate2).test(integer)) {
                System.out.println(integer+"---");
            }
        }
    }
}
