package com.rookie.bigdata.builder.improve;

/**
 * @Classname CommonHouse
 * @Description
 * @Author rookie
 * @Date 2022/11/8 21:30
 * @Version 1.0
 */
public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        //  Auto-generated method stub
        System.out.println(" 普通房子打地基5米 ");
    }

    @Override
    public void buildWalls() {
        //  Auto-generated method stub
        System.out.println(" 普通房子砌墙10cm ");
    }

    @Override
    public void roofed() {
        //  Auto-generated method stub
        System.out.println(" 普通房子屋顶 ");
    }

}

