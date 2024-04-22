package org.ztc.proxy.test.staticProxy;

import org.ztc.proxy.test.staticProxy.proxy.ProxyHello;

/**
 * @ClassName StaticTest
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 7:35
 */
public class StaticTest {
    public static void main(String[] args) {
        ProxyHello hello = new ProxyHello();
        hello.say("Jack");
    }
}
