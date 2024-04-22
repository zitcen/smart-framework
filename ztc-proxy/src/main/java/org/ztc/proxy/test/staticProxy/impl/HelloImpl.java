package org.ztc.proxy.test.staticProxy.impl;

import org.ztc.proxy.test.staticProxy.Hello;

/**
 * @ClassName HelloImpl
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 7:27
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("hello!" + name);
    }
}
