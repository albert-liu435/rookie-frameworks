package com.rookie.bigdata.thread;

/**
 * @Classname AliPayCouponUploadThread2
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/26 17:38
 * @Version 1.0
 */
public class AliPayCouponUploadThread2 implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("执行中");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
