package com.rookie.bigdata.thread;

import java.util.concurrent.Callable;

/**
 * @Classname AliPayCouponUploadThread
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/26 17:36
 * @Version 1.0
 */
public class AliPayCouponUploadThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        Thread.sleep(1000);

        return 1;
    }
}
