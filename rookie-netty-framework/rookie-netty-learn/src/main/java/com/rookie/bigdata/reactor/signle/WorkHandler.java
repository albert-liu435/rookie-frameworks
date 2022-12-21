package com.rookie.bigdata.reactor.signle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Classname WorkHandler
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/9 13:39
 * @Version 1.0
 */
public class WorkHandler implements Runnable {
    private SocketChannel socketChannel;

    public WorkHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer);
            String message = new String(byteBuffer.array(), StandardCharsets.UTF_8);
            System.out.println(socketChannel.getRemoteAddress() + "发来的消息是:" + message);
            //System.out.println("sleep 10s");
            //Thread.sleep(10000);

            socketChannel.write(ByteBuffer.wrap("你的消息我收到了".getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

