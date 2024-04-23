package org.ztc.proxy.test.springaop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingBeforeAdvice
 * @Description 实现spring-aop的前置通知
 * @Author ztc
 * @Date 2024/4/24 6:40
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after");
    }
}
