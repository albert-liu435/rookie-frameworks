package com.rookie.bigdata.proxy.cglib;

/**
 * @Classname TeacherDao
 * @Description
 * @Author rookie
 * @Date 2022/11/11 10:38
 * @Version 1.0
 */
public class TeacherDao {

    public String teach() {
        System.out.println(" 老师授课中  ， 我是cglib代理，不需要实现接口 ");
        return "hello";
    }
}
