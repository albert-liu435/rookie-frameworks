package com.rookie.bigdata.stream;

/**
 * @Classname Person2
 * @Description
 * @Author rookie
 * @Date 2022/11/29 14:01
 * @Version 1.0
 */
public class Person2 {
    private String name;

    public Person2() {
    }

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                '}';
    }
}
