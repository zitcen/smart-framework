package org.ztc.proxy.test.aop.staticP;

import org.ztc.proxy.test.aop.normal.Greeting;
import org.ztc.proxy.test.aop.normal.impl.GreetingImpl;

/**
 * @ClassName ProxyStaticProxy
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 14:25
 */
public class ProxyStaticProxy implements Greeting {

    private GreetingImpl greeting;

    public ProxyStaticProxy(GreetingImpl greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayHello(String name) {
        before();
        greeting.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
