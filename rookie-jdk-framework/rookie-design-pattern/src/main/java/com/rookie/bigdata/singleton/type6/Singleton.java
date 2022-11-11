package com.rookie.bigdata.singleton.type6;

/**
 * @Classname Singleton
 * @Description
 * @Author rookie
 * @Date 2022/11/6 21:20
 * @Version 1.0
 */
public class Singleton {
    private static volatile Singleton instance;

    //构造器私有化
    private Singleton() {}

    //写一个静态内部类,该类中有一个静态属性 Singleton
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE

    public static synchronized Singleton getInstance() {

        return SingletonInstance.INSTANCE;
    }
}
