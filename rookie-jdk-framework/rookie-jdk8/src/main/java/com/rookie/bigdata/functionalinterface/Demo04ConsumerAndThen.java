package com.rookie.bigdata.functionalinterface;

import java.util.function.Consumer;

/**
 * @Classname Demo04ConsumerAndThen
 * @Description
 * @Author rookie
 * @Date 2022/11/28 23:03
 * @Version 1.0
 */
public class Demo04ConsumerAndThen {
    // 使用Lambda表达式先将一个字符串转成小写的字符串,再转成大写
    public static void main(String[] args) {
        System.out.println("开始啦");
        printHello((String str) -> {
            System.out.println(str.toLowerCase());
        }, (String str) -> {
            System.out.println(str.toUpperCase());
        });
    }

    public static void printHello(Consumer<String> c1, Consumer<String> c2) {
        System.out.println("aa");
        String str = "Hello World";
        // c1.accept(str);
        // c2.accept(str);
        //先执行c2的操作，后执行c1的操作
        c2.andThen(c1).accept(str);

    }
}
