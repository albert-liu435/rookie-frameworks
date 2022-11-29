package com.rookie.bigdata.interfaceupgrade;

/**
 * @Classname Demo03UseStaticFunction
 * @Description
 * @Author rookie
 * @Date 2022/11/28 22:52
 * @Version 1.0
 */
public class Demo03UseStaticFunction {
    public static void main(String[] args) {
        BBB bbb = new BBB();
        // bbb.test01();
        // 使用接口名.静态方法名();
        AAA.test01();
    }
}

interface AAA {
    public static void test01() {
        System.out.println("我是接口静态方法");
    }
}

class BBB implements AAA {
    // @Override
    // public static void test01() {
    //     System.out.println("我是接口静态方法");
    // }
}
