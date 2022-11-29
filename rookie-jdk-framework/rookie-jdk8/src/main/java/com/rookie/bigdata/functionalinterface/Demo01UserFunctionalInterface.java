package com.rookie.bigdata.functionalinterface;

/**
 * @Classname Demo01UserFunctionalInterface
 * @Description
 * @Author rookie
 * @Date 2022/11/28 22:54
 * @Version 1.0
 */
public class Demo01UserFunctionalInterface {
    public static void main(String[] args) {
        test((int a, int b) -> {
            System.out.println(a + b);
        });
    }

    public static void test(Operation op) {
        op.getSum(1, 2);
    }
}

interface Operation {
    public abstract void getSum(int a, int b);
}

