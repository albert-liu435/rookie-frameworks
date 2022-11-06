package com.rookie.bigdata.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname LTicket
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/6 9:53
 * @Version 1.0
 */
public class LTicket {
    //票数量
    private int number = 30;

    //创建可重入锁
    private final ReentrantLock lock = new ReentrantLock(true);
    //卖票方法
    public void sale() {
        //上锁
        lock.lock();
        try {
            //判断是否有票
            if(number > 0) {
                System.out.println(Thread.currentThread().getName()+" ：卖出"+(number--)+" 剩余："+number);
            }
        } finally {
            //解锁
            lock.unlock();
        }
    }
}
