package com.rookie.bigdata.singleton.type7;

/**
 * @Classname SingletonTest08
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/6 21:24
 * @Version 1.0
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

//        instance.sayOK();
    }
}
