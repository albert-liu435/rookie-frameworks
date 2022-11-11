package com.rookie.bigdata.adapter.interfaceadapter;

/**
 * @Classname Client
 * @Description
 * @Author rookie
 * @Date 2022/11/8 22:11
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {

        AbsAdapter absAdapter = new AbsAdapter() {
            //只需要去覆盖我们 需要使用 接口方法
            @Override
            public void m1() {
                //  Auto-generated method stub
                System.out.println("使用了m1的方法");
            }
        };

        absAdapter.m1();
    }
}
