package com.rookie.bigdata.helloworld3;

/**
 * @Classname HelloMBean
 * @Description
 * @Author rookie
 * @Date 2023/2/3 11:18
 * @Version 1.0
 */


/*
 * 接口名必须以MBean结尾
 */
public interface HelloMBean
{
    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(String whoName);
}
