package com.rookie.bigdata.executor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ExecutorTest
 * @Description
 * @Author rookie
 * @Date 2023/2/3 14:10
 * @Version 1.0
 */
public class NewFixedThreadPoolTest {

    public static void main(String[] args) {

//        ServerSocket socket=new ServerSocket();
//        socket.socket();



        // 创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName()
                                + "正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}


