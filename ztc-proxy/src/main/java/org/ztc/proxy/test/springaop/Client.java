package org.ztc.proxy.test.springaop;

import org.springframework.aop.framework.ProxyFactory;
import org.ztc.proxy.test.aop.normal.Greeting;
import org.ztc.proxy.test.aop.normal.impl.GreetingImpl;

/**
 * @ClassName Client
 * @Description 如何织入通知
 * @Author ztc
 * @Date 2024/4/24 6:46
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
//        proxyFactory.addAdvice(new GreetingAfterAdvice());
//        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        Greeting proxy = (Greeting)proxyFactory.getProxy();
        proxy.sayHello("spring AOP ");
    }
}
