package com.rookie.bigdata.singleton.type1;

/**
 * @Classname Singleton
 * @Description 饿汉式(静态变量)
 * @Author rookie
 * @Date 2022/11/6 21:07
 * @Version 1.0
 */
public class Singleton {

    //1、私有化构造方法
    private  Singleton(){

    }
    //2、在类内部创建一个对象实例
    private final static Singleton instance=new Singleton();

    //3、对外提供一个共有的静态 方法，返回实例对选哪个
    public static Singleton getInstance() {
        return instance;
    }

}
