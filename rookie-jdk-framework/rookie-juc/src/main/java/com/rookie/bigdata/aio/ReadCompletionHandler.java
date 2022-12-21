package com.rookie.bigdata.aio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    //用户接受或者发送操作的channel
    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        this.asynchronousSocketChannel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        //读数据完成后
        //数据已经完成并写入到ByteBuffer类型的变量result
        attachment.flip();
        byte[] bytes = new byte[attachment.remaining()];
        attachment.get(bytes);
        String msg = null;
        try {
            msg = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("服务端接收数据：" + msg);
        attachment.clear();

        //重复接收消息,再次调用异步读操作
        this.asynchronousSocketChannel.read(attachment, attachment, new ReadCompletionHandler(this.asynchronousSocketChannel));


    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
