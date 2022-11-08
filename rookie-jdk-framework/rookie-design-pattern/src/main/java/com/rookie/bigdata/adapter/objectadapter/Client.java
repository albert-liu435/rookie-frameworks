package com.rookie.bigdata.adapter.objectadapter;

/**
 * @Classname Client
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/8 22:09
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(" === 对象适配器模式 ====");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }

}

