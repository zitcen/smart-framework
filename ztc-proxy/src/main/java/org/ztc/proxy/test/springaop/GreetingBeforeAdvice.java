package org.ztc.proxy.test.springaop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingBeforeAdvice
 * @Description 实现spring-aop的后置通知
 * @Author ztc
 * @Date 2024/4/24 6:40
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before");
    }
}
