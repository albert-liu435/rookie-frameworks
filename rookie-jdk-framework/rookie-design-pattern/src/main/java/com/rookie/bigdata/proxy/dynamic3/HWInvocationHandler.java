package com.rookie.bigdata.proxy.dynamic3;

import com.rookie.bigdata.proxy.dynamic2.HelloService;
import com.rookie.bigdata.proxy.dynamic2.HelloServiceImpl;
import com.rookie.bigdata.proxy.dynamic2.LogInterceptor;
import com.rookie.bigdata.proxy.dynamic2.TransactionInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname HWInvocationHandler
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 14:37
 * @Version 1.0
 */
public class HWInvocationHandler implements InvocationHandler {

    private Object target;

    private Interceptor interceptor;

    public HWInvocationHandler(Object target,Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation(target,method,args);
        return interceptor.intercept(invocation);
    }

    public static Object wrap(Object target,Interceptor interceptor) {
        HWInvocationHandler targetProxy = new HWInvocationHandler(target, interceptor);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),targetProxy);
    }




}