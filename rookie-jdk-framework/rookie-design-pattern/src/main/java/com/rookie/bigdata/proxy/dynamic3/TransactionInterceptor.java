package com.rookie.bigdata.proxy.dynamic3;



/**
 * @Classname TransactionInterceptor
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 14:37
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



    public static void main(String[] args) {
        HelloService target = new HelloServiceImpl();
        Interceptor transactionInterceptor = new TransactionInterceptor();
        HelloService targetProxy = (HelloService) HWInvocationHandler.wrap(target,transactionInterceptor);
        targetProxy.sayHello();
    }
}