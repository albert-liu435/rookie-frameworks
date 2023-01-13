package com.rookie.bigdata.proxy.dynamic4;


/**
 * @Classname LogInterceptor
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 14:32
 * @Version 1.0
 */
public class LogInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Exception {
        System.out.println("------插入前置通知代码-------------");
        Object result = invocation.process();
        System.out.println("------插入后置处理代码-------------");
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return HWInvocationHandler.wrap(target,this);
    }
//    @Override
//    public void intercept() {
//        System.out.println("------插入前置通知代码-------------");
//    }
}
