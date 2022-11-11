package com.rookie.bigdata.lock;

/**
 * @Classname LSaleTicket
 * @Description
 * @Author rookie
 * @Date 2022/11/6 9:53
 * @Version 1.0
 */
public class LSaleTicket {


    //第二步 创建多个线程，调用资源类的操作方法
    //创建三个线程
    public static void main(String[] args) {

        LTicket ticket = new LTicket();

        new Thread(()-> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"AA").start();

        new Thread(()-> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"BB").start();

        new Thread(()-> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"CC").start();
    }
}
