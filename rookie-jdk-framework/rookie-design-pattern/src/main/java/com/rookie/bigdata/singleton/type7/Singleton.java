package com.rookie.bigdata.singleton.type7;

/**
 * @Classname Singleton
 * @Description
 * @Author rookie
 * @Date 2022/11/6 21:23
 * @Version 1.0
 */
public enum Singleton {

    INSTANCE;

    public Singleton getInstance() {
        return INSTANCE;
    }
}
