package com.rookie.bigdata.proxy.dynamic4;


/**
 * @Classname Test
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 15:04
 * @Version 1.0
 */
public class Test {


//    public static void main(String[] args) {
//        HelloService target = new HelloServiceImpl();
//        Interceptor transactionInterceptor = new TransactionInterceptor();
//        //把事务拦截器插入到目标类中
//        target = (HelloService) transactionInterceptor.plugin(target);
//        target.sayHello();
//    }

//        public static void main(String[] args) {
//            HelloService target = new HelloServiceImpl();
//            Interceptor transactionInterceptor = new TransactionInterceptor();
//            target = (HelloService) transactionInterceptor.plugin(target);
//            LogInterceptor logInterceptor = new LogInterceptor();
//            target = (HelloService)logInterceptor.plugin(target);
//            target.sayHello();
//        }


    public static void main(String[] args) {
        HelloService target = new HelloServiceImpl();
        Interceptor transactionInterceptor = new TransactionInterceptor();
        LogInterceptor logInterceptor = new LogInterceptor();
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(transactionInterceptor);
        interceptorChain.addInterceptor(logInterceptor);
        target = (HelloService) interceptorChain.pluginAll(target);
        target.sayHello();
    }


}
