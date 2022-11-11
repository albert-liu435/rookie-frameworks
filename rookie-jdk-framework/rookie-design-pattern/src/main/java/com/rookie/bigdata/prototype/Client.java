package com.rookie.bigdata.prototype;

/**
 * @Classname Client
 * @Description
 * @Author rookie
 * @Date 2022/11/7 22:35
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        //  Auto-generated method stub
        //传统的方法
        Sheep sheep = new Sheep("tom", 1, "白色");

        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep5 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        //....

        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
        //...
    }
}
