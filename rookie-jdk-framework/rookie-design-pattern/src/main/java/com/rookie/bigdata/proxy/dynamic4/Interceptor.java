package com.rookie.bigdata.proxy.dynamic4;


/**
 * @Classname Interceptor
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 15:00
 * @Version 1.0
 */
public interface Interceptor {
    /**
     * 具体拦截处理
     */
    Object intercept(Invocation invocation) throws Exception;

    /**
     *  插入目标类
     */
    Object plugin(Object target);

}
