package com.rookie.bigdata.singleton.type3;

/**
 * @Classname Singleton
 * @Description 懒汉式(线程不安全)
 * @Author rookie
 * @Date 2022/11/6 21:16
 * @Version 1.0
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    //提供一个静态的公有方法，当使用到该方法时，才去创建 instance
    //即懒汉式
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
