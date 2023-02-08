package com.rookie.bigdata.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Classname ChatServer
 * @Description
 * @Author rookie
 * @Date 2022/10/25 23:43
 * @Version 1.0
 */
public class ChatServer {

    //服务器端启动方法
    public void startServer()throws IOException {


        //2、创建ServerSocketChannel通道
        //1、打开 ServerSocketChannel，用于监听客户端的连接，它是所有客户端连接的 父管道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //3、为Channel通道绑定监听端口
        //2、绑定监听端口，设置连接为非阻塞模式
        serverSocketChannel.bind(new InetSocketAddress(8000));
        //设置非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //1、创建Selector选择器
        //3、创建 Reactor 线程，创建多路复用器并启动线程
        Selector selector = Selector.open();

        //4 把channel通道注册到selector选择器上
        //4、将 ServerSocketChannel 注册到 Reactor 线程 的 多路复用器 Selector 上，监听 ACCEPT 事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器已经启动成功了");

        //5、循环、等待有新链接接入
        //5、多路复用器在线程 run()方法 的无限循环体内轮询 准备就绪的 Key
        while (true){
            //获取channel数量
            int readChannels = selector.select();

            if(readChannels == 0) {
                continue;
            }

            //获取可用的channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历集合
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                //移除set集合当前selectionKey
                iterator.remove();

                //6 根据就绪状态，调用对应方法实现具体业务操作
                //6.1 如果accept状态
                if(selectionKey.isAcceptable()) {
                    acceptOperator(serverSocketChannel,selector);
                }
                //6.2 如果可读状态
                if(selectionKey.isReadable()) {
                    readOperator(selector,selectionKey);
                }
            }
        }

    }
    //处理可读状态操作
    private void readOperator(Selector selector, SelectionKey selectionKey) throws IOException {
        //1 从SelectionKey获取到已经就绪的通道
        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

        //2 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //3 循环读取客户端消息
        int readLength = socketChannel.read(byteBuffer);
        String message = "";
        if(readLength >0) {
            //切换读模式
            byteBuffer.flip();

            //读取内容
            message += Charset.forName("UTF-8").decode(byteBuffer);
        }

        //4 将channel再次注册到选择器上，监听可读状态
        //8、将新接入的客户端连接注册到 Reactor 线程 的多路复用器上，监听读操作，读取客户端发送的网络消息
        socketChannel.register(selector,SelectionKey.OP_READ);

        //5 把客户端发送消息，广播到其他客户端
        if(message.length()>0) {
            //广播给其他客户端
            System.out.println(message);
            castOtherClient(message,selector,socketChannel);
        }
    }

    //广播到其他客户端
    private void castOtherClient(String message, Selector selector, SocketChannel socketChannel) throws IOException {
        //1 获取所有已经接入channel
        Set<SelectionKey> selectionKeySet = selector.keys();

        //2 循环想所有channel广播消息
        for(SelectionKey selectionKey : selectionKeySet) {
            //获取每个channel
            Channel tarChannel = selectionKey.channel();
            //不需要给自己发送
            if(tarChannel instanceof SocketChannel && tarChannel != socketChannel) {
                ((SocketChannel)tarChannel).write(Charset.forName("UTF-8").encode(message));
            }
        }
    }

    //处理接入状态操作
    private void acceptOperator(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        //1 接入状态，创建socketChannel
        //6、多路复用器 Selector 监听到有新的客户端接入，处理新的接入请求，完成 TCP 三次握手，建立物理链路
        SocketChannel socketChannel = serverSocketChannel.accept();
        //7、设置客户端链路为非阻塞模式

        //2 把socketChannel设置非阻塞模式
        socketChannel.configureBlocking(false);

        //3 把channel注册到selector选择器上，监听可读状态
        socketChannel.register(selector,SelectionKey.OP_READ);

        //4 客户端回复信息
        socketChannel.write(Charset.forName("UTF-8")
                .encode("欢迎进入聊天室，请注意隐私安全"));
    }

    //启动主方法
    public static void main(String[] args) {
        try {
            new ChatServer().startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
