package com.rookie.bigdata.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Classname HttpServerInitializer
 * @Description TODO
 * @Author rookie
 * @Date 2022/10/31 9:56
 * @Version 1.0
 */
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入处理器
        //得到管道
        ChannelPipeline pipeline = ch.pipeline();
        //加入一个netty提供的httpServerCodec
        //Netty提供的处理http的编解码器
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        //增加一个自定义的handler
        pipeline.addLast("MyHttpServerHandler",new HttpServerHandler());

    }


//    @Override
//    protected void initChannel(SocketChannel ch) throws Exception {
//
//        //向管道加入处理器
//
//        //得到管道
//        ChannelPipeline pipeline = ch.pipeline();
//
//        //加入一个netty 提供的httpServerCodec codec =>[coder - decoder]
//        //HttpServerCodec 说明
//        //1. HttpServerCodec 是netty 提供的处理http的 编-解码器
//        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
//        //2. 增加一个自定义的handler
//        pipeline.addLast("MyTestHttpServerHandler", new TestHttpServerHandler());
//
//        System.out.println("ok~~~~");
//
//    }



}
