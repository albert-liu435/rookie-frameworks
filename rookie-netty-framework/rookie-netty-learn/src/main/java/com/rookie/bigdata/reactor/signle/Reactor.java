package com.rookie.bigdata.reactor.signle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Classname Reactor
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/9 13:37
 * @Version 1.0
 */
public class Reactor implements Runnable {

    ServerSocketChannel serverSocketChannel;
    Selector selector;

    public Reactor(int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            // 注册了连接事件
            SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 并且在selectionKey对象附加了一个Acceptor对象，这是用来处理连接请求的类
            selectionKey.attach(new Acceptor(selector, serverSocketChannel));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    dispatcher(selectionKey);
                    iterator.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void dispatcher(SelectionKey selectionKey) {
        Runnable runnable = (Runnable) selectionKey.attachment();
        runnable.run();
    }
}

