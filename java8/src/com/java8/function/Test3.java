package com.java8.function;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    List<Student> list = null;
    Random random = null;

    public void init() {
        random = new Random();
        list = new ArrayList<Student>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> collect = Stream.generate(() -> random.nextInt(100)).limit(100000000).collect(Collectors.toList());
        long l = System.currentTimeMillis();
        long count = collect.stream().filter(x -> x > 10).filter(x -> x < 90).count();
        System.out.println(count);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        long l2 = System.currentTimeMillis();
        long count2 = collect.stream().parallel().filter(x -> x > 10).filter(x -> x < 90).count();
        System.out.println(count2);
        long l3 = System.currentTimeMillis();
        System.out.println(l3-l2);

        long l4 = System.currentTimeMillis();
        long count1 = collect.stream().filter(x -> x > 10).filter(x -> x < 90).distinct().sorted().count();
        System.out.println(count1);
        long l5 = System.currentTimeMillis();
        System.out.println(l5-l4);


        long l6 = System.currentTimeMillis();
        long count3 = collect.stream().parallel().filter(x -> x > 10).filter(x -> x < 90).distinct().sorted().count();
        System.out.println(count3);
        long l7 = System.currentTimeMillis();
        System.out.println(l7-l6);


    }

    private static void stream12() {
        List<String> list = new ArrayList<String>() {{
            add("user1");
            add("user2");
        }};

        Optional<String> optional = Optional.of("andy with u");
        optional.ifPresent(list::add);
        list.forEach(s-> System.out.println(s));
    }

    private static void stream11() {
        String[] arr = {"a", "b", "c", "d", "e", "f", "g"};
        Arrays.stream(arr).sorted(Comparator.comparing(Test3::com1).thenComparing(String::length)).forEach(System.out::println);
    }

    private static char com1(String x) {
        return x.charAt(0);
    }

    private static void stream10() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
    }

    private static void stream9() {
        List<String> wordList = new ArrayList<String>() {
            {
                add("andy1");
                add("adny1");
                add("andy2");
                add("with");
                add("with");
                add("u");
            }
        };

        wordList.stream().forEach(s -> {
            System.out.println("s->" + s);
            if (s.length() < 4) {
                System.out.println("select->" + s);
                wordList.remove(s);
                System.out.println(wordList);
            }
        });
    }

    private static void stream8() {
        Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        s.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::println);
    }

    private static void stream5() {
        Stream.generate(() -> {
            return Math.random();
        }).limit(10).forEach(System.out::println);
    }

    private static void stream4() {
        Predicate p = o -> o.equals("test");
        Predicate g = o -> o.equals("t");

        System.out.println(p.negate().test("test"));
        System.out.println(p.and(g).test("test"));
        System.out.println(p.or(g).test("test"));
    }


    private static void funciton() {
        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 2;
        System.out.println(f.compose(g).apply(1));
        System.out.println(f.andThen(g).apply(1));
        System.out.println(Function.identity().apply("admin"));
    }

    private static void stream1() {
        Test3 test3 = new Test3();
        test3.init();
        List<String> collect = test3.list.stream().filter(s -> s.getScore() > 80).sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void stream2() {
        Stream<String> limit = Stream.generate(() -> "user").limit(20);

    }

}

class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
