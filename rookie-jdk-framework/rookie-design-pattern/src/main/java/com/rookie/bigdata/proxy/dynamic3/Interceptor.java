package com.rookie.bigdata.proxy.dynamic3;

/**
 * @Classname Interceptor
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 14:37
 * @Version 1.0
 */
public interface Interceptor {
    /**
     * 具体拦截处理
     */
    Object intercept(Invocation invocation) throws Exception;
}
