package com.rookie.bigdata.proxy.dynamic2;

/**
 * @Classname TransactionInterceptor
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 14:32
 * @Version 1.0
 */
public class TransactionInterceptor implements Interceptor {
    @Override
    public void intercept() {
        System.out.println("------插入后置处理代码-------------");
    }
}
