package com.rookie.bigdata.singleton.type1;

/**
 * @Classname SingletonTest01
 * @Description
 * @Author rookie
 * @Date 2022/11/6 21:07
 * @Version 1.0
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }
}


