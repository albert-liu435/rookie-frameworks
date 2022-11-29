package com.rookie.bigdata.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Classname JDK9
 * @Description
 * @Author rookie
 * @Date 2022/11/29 15:07
 * @Version 1.0
 */
//回顾jdk8之前释放资源的代码
public class JDK9 {

    public static void main(String[] args) throws FileNotFoundException {
        //需要释放资源的流，填写在try()中
        FileInputStream fileInputStream = new FileInputStream("F:/a.txt");
        try(fileInputStream){
            //1. 建立程序与文件的数据通道
            //2. 创建字节数组缓冲区
            byte[] buf = new byte[1024];
            int length = 0 ;
            //3. 读取数据，并且输出
            while((length = fileInputStream.read(buf))!=-1){
                System.out.println(new String(buf,0,length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

