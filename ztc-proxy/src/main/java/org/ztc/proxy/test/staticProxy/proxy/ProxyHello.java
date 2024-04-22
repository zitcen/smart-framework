package org.ztc.proxy.test.staticProxy.proxy;

import org.ztc.proxy.test.staticProxy.Hello;
import org.ztc.proxy.test.staticProxy.impl.HelloImpl;

/**
 * @ClassName ProxyHello
 * @Description 静态代理类
 * @Author ztc
 * @Date 2024/4/23 7:30
 */
public class ProxyHello implements Hello {

    private Hello hello;

    public ProxyHello() {
        this.hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
