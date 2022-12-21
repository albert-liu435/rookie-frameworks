package com.rookie.bigdata.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Classname Server
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/6 11:17
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            //创建服务端通道
            AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();

            //绑定端口
            asynchronousServerSocketChannel.bind(new InetSocketAddress(6666));
            System.out.println("服务端启动");


            //接收客户端连接 accept 接收操作是异步操作
            asynchronousServerSocketChannel.accept(null, new AcceptComplationHandler(asynchronousServerSocketChannel));
            //BIO accept操作返回Socket实例  Socket socket= serversocket.accept();
            //AIO accept操作返回AsynchronousSocketChannel

            //accept是异步操作，防止当前程序直接执行结束
            //方法1：while(true)+sleep
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



