package com.rookie.bigdata.functionalinterface;

import java.util.function.Predicate;

/**
 * @Classname Demo07Predicate
 * @Description
 * @Author rookie
 * @Date 2022/11/28 23:16
 * @Version 1.0
 */
public class Demo07Predicate {
    // 使用Lambda判断一个人名如果超过3个字就认为是很长的名字
    public static void main(String[] args) {
        System.out.println("开始啦");
        isLongName((String name) -> {
            return name.length() > 3;
        });
    }

    public static void isLongName(Predicate<String> predicate) {
        System.out.println("aa");
        boolean isLong = predicate.test("迪丽热巴");
        System.out.println("是否是长名字: " + isLong);
    }
}

