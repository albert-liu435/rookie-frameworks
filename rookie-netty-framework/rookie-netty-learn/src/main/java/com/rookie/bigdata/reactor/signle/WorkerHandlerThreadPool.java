package com.rookie.bigdata.reactor.signle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname WorkerHandlerThreadPool
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/9 13:40
 * @Version 1.0
 */
public class WorkerHandlerThreadPool implements Runnable {

    static ExecutorService pool = Executors.newFixedThreadPool(2);

    private SocketChannel socketChannel;

    public WorkerHandlerThreadPool(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            System.out.println("WorkerHandlerThreadPool thread :" + Thread.currentThread().getName());
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            pool.execute(new Process(socketChannel, buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

