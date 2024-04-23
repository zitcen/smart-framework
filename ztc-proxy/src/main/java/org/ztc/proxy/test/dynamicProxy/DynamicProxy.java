package org.ztc.proxy.test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @ClassName DynamicProxy
 * @Description 动态代理类
 * @Author ztc
 * @Date 2024/4/23 7:40
 */
public class DynamicProxy<T> implements InvocationHandler {

    private T target;

    public DynamicProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before(){
        System.out.println("Before");
    }
    private void after(){
        System.out.println("After");
    }

    public T getProxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
