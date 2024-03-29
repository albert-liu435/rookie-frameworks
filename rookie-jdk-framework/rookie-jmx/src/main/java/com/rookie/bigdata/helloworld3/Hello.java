package com.rookie.bigdata.helloworld3;

/**
 * @Classname Hello
 * @Description
 * @Author rookie
 * @Date 2023/2/3 11:17
 * @Version 1.0
 */

/*
 * 该类名称必须与实现的接口的前缀保持一致（即MBean前面的名称
 */
public class Hello implements HelloMBean
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void printHello()
    {
        System.out.println("Hello World, " + name);
    }

    public void printHello(String whoName)
    {
        System.out.println("Hello , " + whoName);
    }
}