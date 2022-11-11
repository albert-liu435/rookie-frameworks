package com.rookie.bigdata.adapter.classadapter;

/**
 * @Classname Client
 * @Description
 * @Author rookie
 * @Date 2022/11/8 22:02
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        //  Auto-generated method stub
        System.out.println(" === 类适配器模式 ====");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }

}

