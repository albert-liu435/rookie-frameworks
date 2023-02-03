package com.rookie.bigdata.helloworld;

/**
 * @Classname Hello
 * @Description
 * @Author rookie
 * @Date 2023/2/3 9:38
 * @Version 1.0
 */
public class Hello implements HelloMBean {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String printHello() {
        return "Hello "+ name;
    }

    @Override
    public String printHello(String whoName) {
        return "Hello  " + whoName;
    }
}
