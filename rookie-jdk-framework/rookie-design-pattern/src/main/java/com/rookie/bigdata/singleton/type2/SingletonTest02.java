package com.rookie.bigdata.singleton.type2;

import com.rookie.bigdata.singleton.type1.Singleton;

/**
 * @Classname SingletonTest02
 * @Description
 * @Author rookie
 * @Date 2022/11/6 21:15
 * @Version 1.0
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        //测试
        com.rookie.bigdata.singleton.type1.Singleton instance = com.rookie.bigdata.singleton.type1.Singleton.getInstance();
        com.rookie.bigdata.singleton.type1.Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }
}
