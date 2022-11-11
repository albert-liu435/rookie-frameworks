package com.rookie.bigdata.proxy.dynamic;

/**
 * @Classname TeacherDao
 * @Description
 * @Author rookie
 * @Date 2022/11/11 10:05
 * @Version 1.0
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        //  Auto-generated method stub
        System.out.println(" 老师授课中.... ");
    }

    @Override
    public void sayHello(String name) {
        //  Auto-generated method stub
        System.out.println("hello " + name);
    }

}