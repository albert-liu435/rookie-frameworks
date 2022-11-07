package com.rookie.bigdata.singleton.type2;

/**
 * @Classname Singleton
 * @Description 饿汉式(静态变量)
 * @Author rookie
 * @Date 2022/11/6 21:15
 * @Version 1.0
 */
public class Singleton {

    //1. 构造器私有化, 外部能new
    private Singleton() {

    }


    //2.本类内部创建对象实例
    private static Singleton instance;

    static { // 在静态代码块中，创建单例对象
        instance = new Singleton();
    }

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}
