package com.rookie.bigdata.lambda;

/**
 * @Classname Demo02LambdaUse
 * @Description
 * @Author rookie
 * @Date 2022/11/28 22:19
 * @Version 1.0
 */
public class Demo02LambdaUse {
    public static void main(String[] args) {

        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("凤姐 自由泳.");
            }
        });

        // 小结:Lambda表达式相当于是对接口抽象方法的重写
        goSwimming(()->{
            System.out.println("如花 蛙泳");
        });



    }


    //无参无返回值的Lambda
    public static void  goSwimming(Swimmable swimmable){
        swimmable.swimming();
    }





}
