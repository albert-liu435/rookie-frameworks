package com.rookie.bigdata.reactor.signle;

/**
 * @Classname Main
 * @Description TODO
 * @Author rookie
 * @Date 2022/12/9 13:37
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Reactor reactor = new Reactor(9090);
        reactor.run();
    }
}


