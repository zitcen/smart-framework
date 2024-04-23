package org.ztc.proxy.test.aop.staticP;

import org.ztc.proxy.test.aop.normal.impl.GreetingImpl;
import sun.applet.Main;

/**
 * @ClassName StaticProxTest
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 14:27
 */
public class StaticProxTest {
    public static void main(String[] args) {
        GreetingImpl greeting = new GreetingImpl();
        ProxyStaticProxy proxyStaticProxy = new ProxyStaticProxy(greeting);
        proxyStaticProxy.sayHello("static proxy");
    }
}
