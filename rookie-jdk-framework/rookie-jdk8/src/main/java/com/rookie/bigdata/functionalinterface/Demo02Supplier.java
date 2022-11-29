package com.rookie.bigdata.functionalinterface;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @Classname Demo02Supplier
 * @Description
 * @Author rookie
 * @Date 2022/11/28 22:59
 * @Version 1.0
 */
public class Demo02Supplier {
    // 使用Lambda表达式返回数组元素最大值
    public static void main(String[] args) {
        System.out.println("开始了");
        printMax(() -> {
            //这个相当于supplier.get()的实现
            int[] arr = {11, 99, 88, 77, 22};
            Arrays.sort(arr); // 升序排序
            return arr[arr.length - 1];
        });
    }

    public static void printMax(Supplier<Integer> supplier) {
        System.out.println("aa");
        int max = supplier.get();
        System.out.println("max = " + max);
    }
}
