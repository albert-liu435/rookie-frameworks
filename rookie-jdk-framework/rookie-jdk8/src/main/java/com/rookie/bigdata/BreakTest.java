package com.rookie.bigdata;

/**
 * @Classname BreakTest
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/30 17:38
 * @Version 1.0
 */
public class BreakTest{
    public static void main(String[] args){
        for(int i=1;i<5;i++){
            if(i == 5){
                break;//终止的是for循环
            }
            System.out.println(i);
        }

        //这里到的程序和以上的for循环无关。
        System.out.println("HelloWorld!");

        System.out.println("====================================");
        for(int j = 0;j<3;j++){
            for(int i = 1;i<5;i++){
                if(i == 5){
                    break;//当前的break语句终止的是内层for循环。因为这个for离它最近。
                    //这里的break语句不会影响到外层for循环。
                }
                System.out.println(i);
            }
        }

        System.out.println("HelloWorld!");

		/* //给for循环起名for1
		for1:for(int j = 0;j<3;j++){
			for2:for(int i = 1;i<5;i++){
				if(i == 5){
					break for2;//终止for2循环
				}
				System.out.println(i);
			}
		}

		System.out.println("HelloWorld!"); */
    }
}
