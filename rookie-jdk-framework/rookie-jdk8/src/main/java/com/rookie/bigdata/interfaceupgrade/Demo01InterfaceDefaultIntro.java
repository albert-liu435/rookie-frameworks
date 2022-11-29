package com.rookie.bigdata.interfaceupgrade;

/**
 * @Classname Demo01InterfaceDefaultIntro
 * @Description
 * @Author rookie
 * @Date 2022/11/28 22:38
 * @Version 1.0
 */
interface A {
    public abstract void test01();
    //接口
    // public abstract void test02();
}

class B implements A {
    @Override
    public void test01() {
        System.out.println("B test01");
    }
}

class C implements A {
    @Override
    public void test01() {
        System.out.println("C test01");
    }
}
