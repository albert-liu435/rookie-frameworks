package com.rookie.bigdata.proxy.dynamic2;

/**
 * @Classname LogInterceptor
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 14:32
 * @Version 1.0
 */
public class LogInterceptor implements Interceptor {
    @Override
    public void intercept() {
        System.out.println("------插入前置通知代码-------------");
    }
}
