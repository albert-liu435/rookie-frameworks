package com.rookie.bigdata.singleton.type5;

/**
 * @Classname Singleton
 * @Description 懒汉式(线程安全 ， 同步方法)
 * @Author rookie
 * @Date 2022/11/6 21:20
 * @Version 1.0
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    //提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
    //同时保证了效率, 推荐使用

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }

        }
        return instance;
    }
}
