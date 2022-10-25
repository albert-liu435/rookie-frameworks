package com.rookie.bigdata.day02.channel;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname FileChannelDemo
 * @Description TODO
 * @Author rookie
 * @Date 2022/10/24 23:40
 * @Version 1.0
 */
public class FileChannelDemo {

    //FileChannel读取数据到buffer中
    @Test
    public void test1() throws Exception {
        //创建FileChannel
        RandomAccessFile aFile = new RandomAccessFile("E:\\IDEAWorkspace\\rookie-github\\rookie-frameworks\\rookie-jdk-framework\\rookie-nio\\src\\main\\java\\com\\rookie\\bigdata\\day01\\TestBlockingNIO.java", "rw");
        FileChannel channel = aFile.getChannel();

        //创建Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //读取数据到buffer中
        int bytesRead = channel.read(buf);
        while (bytesRead != -1) {
            System.out.println("读取了：" + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }
            buf.clear();
            bytesRead = channel.read(buf);
        }
        aFile.close();
        System.out.println("结束了");


    }

    /**
     * 写数据
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        // 打开FileChannel
        RandomAccessFile aFile = new RandomAccessFile("E:\\IDEAWorkspace\\rookie-github\\rookie-frameworks\\rookie-jdk-framework\\rookie-nio\\src\\main\\java\\com\\rookie\\bigdata\\day01\\a.txt", "rw");
        FileChannel channel = aFile.getChannel();

        //创建buffer对象
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String newData = "data atguigu";
        buffer.clear();

        //写入内容
        buffer.put(newData.getBytes());

        buffer.flip();

        //FileChannel完成最终实现
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }

        //关闭
        channel.close();

    }

    /**
     * 通道之间数据传输
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        // 创建两个fileChannel
        RandomAccessFile aFile = new RandomAccessFile("E:\\IDEAWorkspace\\rookie-github\\rookie-frameworks\\rookie-jdk-framework\\rookie-nio\\src\\main\\java\\com\\rookie\\bigdata\\day01\\TestBlockingNIO.java", "rw");
        FileChannel fromChannel = aFile.getChannel();

        RandomAccessFile bFile = new RandomAccessFile("E:\\IDEAWorkspace\\rookie-github\\rookie-frameworks\\rookie-jdk-framework\\rookie-nio\\src\\main\\java\\com\\rookie\\bigdata\\day01\\a.txt", "rw");
        FileChannel toChannel = bFile.getChannel();

        //fromChannel 传输到 toChannel
        long position = 0;
        long size = fromChannel.size();
        toChannel.transferFrom(fromChannel, position, size);

        aFile.close();
        bFile.close();
        System.out.println("over!");
    }
}
