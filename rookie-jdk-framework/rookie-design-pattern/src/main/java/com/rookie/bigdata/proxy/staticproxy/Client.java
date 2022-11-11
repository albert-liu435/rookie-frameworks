package com.rookie.bigdata.proxy.staticproxy;

/**
 * @Classname Client
 * @Description
 * @Author rookie
 * @Date 2022/11/11 9:44
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        //  Auto-generated method stub
        //创建目标对象(被代理对象)
        TeacherDao teacherDao = new TeacherDao();

        //创建代理对象, 同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        //通过代理对象，调用到被代理对象的方法
        //即：执行的是代理对象的方法，代理对象再去调用目标对象的方法
        teacherDaoProxy.teach();
    }

}

