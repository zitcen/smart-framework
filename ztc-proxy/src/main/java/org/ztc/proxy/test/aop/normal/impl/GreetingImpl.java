package org.ztc.proxy.test.aop.normal.impl;

import org.ztc.proxy.test.aop.normal.Greeting;

/**
 * @ClassName GreetingImpl
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 14:17
 */
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
//        before();
        System.out.println("Hello " + name);
//        after();
    }

//    private void before(){
//        System.out.println("Before");
//    }
//
//    private void after(){
//        System.out.println("After");
//    }
}
