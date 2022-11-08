package com.rookie.bigdata.builder;

/**
 * @Classname CommonHouse
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/7 22:58
 * @Version 1.0
 */
public class CommonHouse extends AbstractHouse {

    @Override
    public void buildBasic() {
        // TODO Auto-generated method stub
        System.out.println(" 普通房子打地基 ");
    }

    @Override
    public void buildWalls() {
        // TODO Auto-generated method stub
        System.out.println(" 普通房子砌墙 ");
    }

    @Override
    public void roofed() {
        // TODO Auto-generated method stub
        System.out.println(" 普通房子封顶 ");
    }

}
