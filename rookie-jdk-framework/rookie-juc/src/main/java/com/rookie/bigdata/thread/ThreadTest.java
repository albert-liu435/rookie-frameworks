package com.rookie.bigdata.thread;

/**
 * @Classname ThreadTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/1 22:39
 * @Version 1.0
 */
public class ThreadTest {
    static Publish publish;

    public static void main(String[] args) {
        System.out.println("Initial active threads : " + Thread.activeCount());
        publish = new Publish();
        publish.start();
    }

    static class Publish extends Thread {
        static int counter = 1;

        public void run() {
            while (true) {
                System.out.println("counter is: " + counter);
                counter++;
                try {
                    Thread.sleep(2000);
                    if (counter > 5) {
                        throw new InterruptedException("Exception thrown manually to restart thread");
                    }
                } catch (Exception ex) {
                    counter = 1;
                    publish = new Publish();
                    publish.start();
                    System.out.println("active threads : " + Thread.activeCount());
                    return;
                }
            }

        }
    }
}