package org.ztc.proxy.test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxy
 * @Description 动态代理类
 * @Author ztc
 * @Date 2024/4/23 7:40
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
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
}
