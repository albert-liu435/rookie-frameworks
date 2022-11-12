package com.rookie.bigdata.mybatis.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Classname User
 * @Description
 * @Author rookie
 * @Date 2022/11/10 22:49
 * @Version 1.0
 */
public class User implements Serializable {

    private int id;
    private String username;
    private String password;
    private Date birthday;



    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
