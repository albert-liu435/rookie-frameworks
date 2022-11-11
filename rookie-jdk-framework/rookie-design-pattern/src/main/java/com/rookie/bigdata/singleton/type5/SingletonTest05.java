package com.rookie.bigdata.singleton.type5;

/**
 * @Classname SingletonTest06
 * @Description
 * @Author rookie
 * @Date 2022/11/6 21:20
 * @Version 1.0
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        System.out.println("双重检查");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }
}
