package org.ztc.proxy.test.aop.jdkDynam;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKDynamicProxy
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 14:29
 */
public class JDKDynamicProxy<T> implements InvocationHandler {

    private T target;

    public JDKDynamicProxy(T target) {
        this.target = target;
    }

    public T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;

    }
    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
