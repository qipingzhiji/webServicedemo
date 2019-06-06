package com.java8.function;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {
        stream8();
    }

    private static void list1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().filter(n -> n > 3 && n % 2 == 0).forEach(n -> System.out.println(n));
    }

    private static void consumer(List<Integer> list, BiConsumer<Integer, Integer> biConsumer) {
        for (Integer n : list) {
            biConsumer.accept(n, n);
        }
    }


    private static void stream1() {
        Stream<Person> stream = Stream.of(new Person("1", "林肯"), new Person("2", "林肯2"));
        Map<String, List<Person>> maps = stream.collect(Collectors.groupingBy(Person::getId));
        for (String s : maps.keySet()) {
            System.out.println(s + "=====>" + maps.get(s));
        }
    }

    private static void stream2() {
        Stream<Person> stream1 = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, List<Person>> collect = stream1.collect(Collectors.partitioningBy(Person::isMyLove));
        collect.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }

    private static void stream3() {
        Stream<Person> stream1 = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, Long> collect = stream1.collect(Collectors.partitioningBy(Person::isMyLove, Collectors.counting()));
        collect.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }

    private static void stream4() {
        Stream<Person> stream = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, Integer> collect = stream.collect(Collectors.partitioningBy(Person::isMyLove, Collectors.summingInt(a -> new Integer(((Person) a).getId()))));
        collect.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    private static void stream5() {
        Stream<Person> stream = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, Optional<Person>> collect = stream.collect(Collectors.partitioningBy(Person::isMyLove, Collectors.maxBy(Comparator.comparing(Person::getId))));
        collect.forEach((k,v)->{
            System.out.println(k + ":" + v);
        });
    }

    private static void stream6() {
        Stream<Person> stream = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, Optional<Person>> collect = stream.collect(Collectors.partitioningBy(Person::isMyLove, Collectors.minBy(Comparator.comparing(Person::getId))));
        collect.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }

    private static void stream7() {
        Stream<Person> stream = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, Optional<String>> collect = stream.collect(Collectors.partitioningBy(Person::isMyLove, Collectors.mapping(Person::getId, Collectors.minBy(Comparator.comparing(String::length)))));
        collect.forEach((k,v)->{
            System.out.println(k + ":" +  v);
        });
    }

    private static void stream8() {
        Stream<Person> stream = Stream.of(new Person("1", "林肯"), new Person("2", "冰儿"), new Person("3", "忽忽"));
        Map<Boolean, Optional<Person>> collect = stream.collect(Collectors.partitioningBy(Person::isMyLove, Collectors.reducing((a, b) -> a)));
        collect.keySet().forEach((k)->{
            System.out.println(k + "---->" + collect.get(k));
        });
    }

    private static class Person {
        private String id;
        private String name;


        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }


        public boolean isMyLove() {
            if ("冰儿".equals(name)) {
                return true;
            }
            return false;
        }


        public String getId() {
            return id;
        }


        public void setId(String id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "Person [id=" + id + ", name=" + name + "]";
        }
    }
}
