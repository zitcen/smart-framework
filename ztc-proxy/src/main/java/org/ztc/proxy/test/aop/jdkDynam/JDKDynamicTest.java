package org.ztc.proxy.test.aop.jdkDynam;

import org.ztc.proxy.test.aop.normal.Greeting;
import org.ztc.proxy.test.aop.normal.impl.GreetingImpl;

/**
 * @ClassName JDKDynamicTest
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 14:35
 */
public class JDKDynamicTest {
    public static void main(String[] args) {
        JDKDynamicProxy<Greeting> jdkDynamicProxy =  new JDKDynamicProxy<>(new GreetingImpl());
        Greeting greeting = jdkDynamicProxy.getProxy();
        greeting.sayHello("JDK ");
    }
}
