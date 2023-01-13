package com.rookie.bigdata.proxy.dynamic4;


/**
 * @Classname TransactionInterceptor
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 15:00
 * @Version 1.0
 */
public class TransactionInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Exception{
        System.out.println("------插入前置通知代码-------------");
        Object result = invocation.process();
        System.out.println("------插入后置处理代码-------------");
        return result;
    }

//    @Override
//    public Object intercept(com.rookie.bigdata.proxy.dynamic4.Invocation invocation) throws Exception {
//        return null;
//    }

    @Override
    public Object plugin(Object target) {
        return HWInvocationHandler.wrap(target,this);
    }
}