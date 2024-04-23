package org.ztc.proxy.test.cglib;

import org.ztc.proxy.test.staticProxy.Hello;
import org.ztc.proxy.test.staticProxy.impl.HelloImpl;

/**
 * @ClassName CGlibTest
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 9:27
 */
public class CGlibTest {
    public static void main(String[] args) {
        CGlibProxy cGlibProxy = CGlibProxy.getInstance();
        Hello proxy = cGlibProxy.getProxy(HelloImpl.class);
        proxy.say("CGlib");
    }
}
