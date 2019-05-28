package com.springboot.activemq.springbootactivemq.entity;

public class Cat {
    private String name;
    private int sex;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
