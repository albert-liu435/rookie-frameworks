package com.rookie.bigdata.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Classname Test1
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/26 17:33
 * @Version 1.0
 */
public class Test1 {


    public static void main(String[] args) throws Exception{


//        List<Callable<Integer>> tasks = new ArrayList<>();
        AlipayThreadPoolUtil csThreadPoolUtil = AlipayThreadPoolUtil.init();
        for(int i=0;i<10;i++) {
            AliPayCouponUploadThread2 aliPayCouponUploadThread = new AliPayCouponUploadThread2();
//            tasks.add(aliPayCouponUploadThread);

            csThreadPoolUtil.execute(aliPayCouponUploadThread);
        }
//            List<Future<Integer>> futures = csThreadPoolUtil.executeInteger(tasks);


        System.out.println("hello");
    }

//    public static void main(String[] args) {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 1; i <= 10; i++) {
//            final int index = i;
//            fixedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    String threadName = Thread.currentThread().getName();
////                    Log.v("zy", "线程："+threadName+",正在执行第" + index + "个任务");
//                    System.out.println("zy"+ "线程："+threadName+",正在执行第" + index + "个任务");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//
//        System.out.println("helllo");
//
//
//    }
}
