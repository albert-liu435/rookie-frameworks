package com.rookie.bigdata.singleton.type6;

/**
 * @Classname SingletonTest07
 * @Description
 * @Author rookie
 * @Date 2022/11/6 21:22
 * @Version 1.0
 */
public class SingletonTest06 {
    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }
}
