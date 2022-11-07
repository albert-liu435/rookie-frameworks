package com.rookie.bigdata.singleton.type4;

/**
 * @Classname Singleton
 * @Description 懒汉式(线程安全，同步方法)
 * @Author rookie
 * @Date 2022/11/6 21:18
 * @Version 1.0
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    //即懒汉式
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
