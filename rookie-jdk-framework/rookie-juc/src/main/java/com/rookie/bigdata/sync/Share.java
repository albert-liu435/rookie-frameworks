package com.rookie.bigdata.sync;

/**
 * @Classname Share
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/6 10:15
 * @Version 1.0
 */
public //第一步 创建资源类，定义属性和操作方法
class Share {
    //初始值
    private int number = 0;

    //+1的方法
    public synchronized void incr() throws InterruptedException {
        //第二步 判断 干活 通知
        while (number != 0) { //判断number值是否是0，如果不是0，等待
            this.wait(); //在哪里睡，就在哪里醒
        }
        //如果number值是0，就+1操作
        number++;
        System.out.println(Thread.currentThread().getName() + " :: " + number);
        //通知其他线程
        this.notifyAll();
    }

    //-1的方法
    public synchronized void decr() throws InterruptedException {
        //判断
        while (number != 1) {
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName() + " :: " + number);
        //通知其他线程
        this.notifyAll();
    }
}