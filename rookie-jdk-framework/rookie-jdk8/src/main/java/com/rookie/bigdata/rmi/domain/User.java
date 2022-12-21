package com.rookie.bigdata.rmi.domain;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/19 10:08
 * @Version 1.0
 */
public class User implements Serializable {
    // 服务端 客户端的serialVersionUID字段数据要保持一致
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
