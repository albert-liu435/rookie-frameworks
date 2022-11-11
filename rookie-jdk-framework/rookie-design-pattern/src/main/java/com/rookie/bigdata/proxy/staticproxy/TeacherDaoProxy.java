package com.rookie.bigdata.proxy.staticproxy;

/**
 * @Classname TeacherDaoProxy
 * @Description
 * @Author rookie
 * @Date 2022/11/11 9:44
 * @Version 1.0
 */
//代理对象,静态代理
public class TeacherDaoProxy implements ITeacherDao{

    private ITeacherDao target; // 目标对象，通过接口来聚合


    //构造器
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }



    @Override
    public void teach() {
        //  Auto-generated method stub
        System.out.println("开始代理  完成某些操作。。。。。 ");//方法
        target.teach();
        System.out.println("提交。。。。。");//方法
    }

}
