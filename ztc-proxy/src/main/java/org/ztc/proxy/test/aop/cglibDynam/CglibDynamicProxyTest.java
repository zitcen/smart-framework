package org.ztc.proxy.test.aop.cglibDynam;

import org.ztc.proxy.test.aop.normal.impl.GreetingImpl;

/**
 * @ClassName CglibDynamicProxyTest
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 17:37
 */
public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        CglibDynamicProxy instance = CglibDynamicProxy.getInstance();
        GreetingImpl proxy = instance.getProxy(GreetingImpl.class);
        proxy.sayHello("CGlib ");
    }
}
