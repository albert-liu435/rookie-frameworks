package com.rookie.bigdata.lambda;

/**
 * @Classname Demo06LambdaCondition
 * @Description
 * @Author rookie
 * @Date 2022/11/28 22:25
 * @Version 1.0
 */

public class Demo06LambdaCondition {
    public static void main(String[] args) {
        // 方法的参数或局部变量类型必须为接口才能使用Lambda
        test(() -> {
        });

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("aa");
            }
        };

        Flyable f = () -> {
            System.out.println("我会飞啦");
        };
    }

    public static void test(Flyable a) {
        new Person() {

        };
    }

}

// 只有一个抽象方法的接口称为函数式接口,我们就能使用Lambda
@FunctionalInterface // 检测这个接口是不是只有一个抽象方法
interface Flyable {
    // 接口中有且仅有一个抽象方法
    public abstract void eat();
    // public abstract void eat2();
}
