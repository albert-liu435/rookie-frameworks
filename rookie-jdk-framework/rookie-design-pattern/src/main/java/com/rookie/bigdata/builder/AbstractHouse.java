package com.rookie.bigdata.builder;

/**
 * @Classname AbstractHouse
 * @Description
 * @Author rookie
 * @Date 2022/11/7 22:58
 * @Version 1.0
 */

public abstract class AbstractHouse {

    //打地基
    public abstract void buildBasic();
    //砌墙
    public abstract void buildWalls();
    //封顶
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }

}

