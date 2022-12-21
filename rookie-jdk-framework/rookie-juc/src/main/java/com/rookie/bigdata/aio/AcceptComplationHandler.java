package com.rookie.bigdata.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptComplationHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    private AsynchronousServerSocketChannel channel;

    public AcceptComplationHandler(AsynchronousServerSocketChannel channel) {
        this.channel = channel;
    }


    @Override
    public void completed(AsynchronousSocketChannel result, Object attachment) {
        System.out.println("有新客户的连接");
        //完成accept连接IO操作
        //读写操作，需要使用Buffer，和NIO比较，当前AIO称之为NIO.2
        //创建新的buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //读客户端数据，读操作是异步操作,需要实现CompletionHandler对象
        /**
         * <A> void read(ByteBuffer dst,A attachment,CompletionHandler<Integer,? super A> handler);
         * 读操作异步方式方法解读
         * 第一个参数：dst  数据读取的目的地
         * 第二个参数：attachment  给读回调传递的额外信息
         * 第三个参数：CompletionHandler 当读数据完成后CompletionHandler对象
         */
        result.read(byteBuffer, byteBuffer, new ReadCompletionHandler(result));

        //再次接收其他的客户端连接的
        channel.accept(null, new AcceptComplationHandler(channel));

    }

    @Override
    public void failed(Throwable exc, Object attachment) {

    }
}
