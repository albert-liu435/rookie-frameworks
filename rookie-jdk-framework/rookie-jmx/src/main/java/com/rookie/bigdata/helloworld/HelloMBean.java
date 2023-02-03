package com.rookie.bigdata.helloworld;

/**
 * @Classname HelloMBean
 * @Description HelloMBean
 * @Author rookie
 * @Date 2023/2/2 16:56
 * @Version 1.0
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public String printHello();

    public String printHello(String whoName);

}
