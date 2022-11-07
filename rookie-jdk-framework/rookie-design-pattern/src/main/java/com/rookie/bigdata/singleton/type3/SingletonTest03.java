package com.rookie.bigdata.singleton.type3;

/**
 * @Classname SingletonTest03
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/6 21:17
 * @Version 1.0
 */
public class SingletonTest03 {
    public static void main(String[] args) {
        System.out.println("懒汉式1 ， 线程不安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}
