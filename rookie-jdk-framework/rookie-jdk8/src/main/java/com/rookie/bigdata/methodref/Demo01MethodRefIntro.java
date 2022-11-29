package com.rookie.bigdata.methodref;

import java.util.function.Consumer;

/**
 * @Classname Demo01MethodRefIntro
 * @Description
 * @Author rookie
 * @Date 2022/11/28 23:22
 * @Version 1.0
 */
public class Demo01MethodRefIntro {
    // 求一个数组的和
    public static void getMax(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        // 使用Lambda表达式求一个数组的和
        /*printMax((int[] arr) -> {
            getMax(arr);
        });*/

        // 使用方法引用
        // 让这个指定的方法去重写接口的抽象方法,到时候调用接口的抽象方法就是调用传递过去的这个方法
        printMax(Demo01MethodRefIntro::getMax);
    }

    public static void printMax(Consumer<int[]> consumer) {
        int[] arr = {11, 22, 33, 44, 55};
        consumer.accept(arr);
    }
}