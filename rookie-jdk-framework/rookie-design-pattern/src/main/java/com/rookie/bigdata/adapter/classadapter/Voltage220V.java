package com.rookie.bigdata.adapter.classadapter;

/**
 * @Classname Voltage220V
 * @Description
 * @Author rookie
 * @Date 2022/11/8 21:59
 * @Version 1.0
 */
//被适配的类
public class Voltage220V {
    //输出220V的电压
    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}

