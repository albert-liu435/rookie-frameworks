package com.rookie.bigdata.sync;

/**
 * @Classname SaleTicket
 * @Description
 * @Author rookie
 * @Date 2022/11/5 14:47
 * @Version 1.0
 */
public class SaleTicket {
    public static void main(String[] args) {
        //创建多个线程，调用资源类的操作方法
        Ticket ticket=new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<40;i++){
                    ticket.sales();
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<40;i++){
                    ticket.sales();
                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<40;i++){
                    ticket.sales();
                }
            }
        },"CC").start();
    }

}
//public class SaleTicket {
//    //第二步 创建多个线程，调用资源类的操作方法
//    public static void main(String[] args) {
//        //创建Ticket对象
//        Ticket ticket = new Ticket();
//        //创建三个线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //调用卖票方法
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        },"AA").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //调用卖票方法
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        },"BB").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //调用卖票方法
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        },"CC").start();
//    }