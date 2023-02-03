package com.rookie.bigdata.helloworld2;

/**
 * @Classname HelloMBean
 * @Description 该类名称必须与实现的接口的前缀保持一致（即MBean前面的名称)
 * @Author rookie
 * @Date 2023/2/3 10:54
 * @Version 1.0
 */

public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public String getAge();

    public void setAge(String age);

    public void helloWorld();

    public void helloWorld(String str);

    public void getTelephone();
}
