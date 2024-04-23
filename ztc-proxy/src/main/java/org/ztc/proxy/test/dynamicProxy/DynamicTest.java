package org.ztc.proxy.test.dynamicProxy;

import org.ztc.proxy.test.staticProxy.Hello;
import org.ztc.proxy.test.staticProxy.impl.HelloImpl;

import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicTest
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 7:49
 */
public class DynamicTest {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy<Hello> proxy = new DynamicProxy<>(hello);
        Hello proxyProxy = proxy.getProxy();
        proxyProxy.say("T");
//        Hello helloProxy = (Hello)Proxy.newProxyInstance(
//                hello.getClass().getClassLoader(),
//                hello.getClass().getInterfaces(),
//                proxy
//        );
//        helloProxy.say("dynamic test");

//        hellopr.say("name");
    }
}
