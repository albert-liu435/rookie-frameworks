package com.rookie.bigdata.builder.improve;

/**
 * @Classname HouseBuilder
 * @Description
 * @Author rookie
 * @Date 2022/11/8 21:30
 * @Version 1.0
 */
// 抽象的建造者
public abstract class HouseBuilder {

    protected House house = new House();

    //将建造的流程写好, 抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造房子好， 将产品(房子) 返回
    public House buildHouse() {
        return house;
    }

}