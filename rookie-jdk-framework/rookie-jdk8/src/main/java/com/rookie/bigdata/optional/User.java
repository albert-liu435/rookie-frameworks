package com.rookie.bigdata.optional;

/**
 * @Classname User
 * @Description
 * @Author rookie
 * @Date 2022/11/29 14:16
 * @Version 1.0
 */
public class User {
    private String userName;
    private int age;

    public User() {
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

