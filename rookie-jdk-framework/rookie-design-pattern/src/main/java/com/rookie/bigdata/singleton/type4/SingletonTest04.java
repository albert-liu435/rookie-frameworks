package com.rookie.bigdata.singleton.type4;

/**
 * @Classname SingletonTest04
 * @Description
 * @Author rookie
 * @Date 2022/11/6 21:18
 * @Version 1.0
 */
public class SingletonTest04 {
    public static void main(String[] args) {
        System.out.println("懒汉式2 ， 线程安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}
