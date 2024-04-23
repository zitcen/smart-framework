package org.ztc.proxy.test.aop.cglibDynam;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.ztc.proxy.test.cglib.CGlibProxy;

import java.lang.reflect.Method;

/**
 * @ClassName cglibDynam
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 15:56
 */
public class CglibDynamicProxy implements MethodInterceptor {

    private static CglibDynamicProxy instance = new CglibDynamicProxy();
    private CglibDynamicProxy(){

    }

    public static CglibDynamicProxy getInstance(){
        return instance;
    }
    public <T> T getProxy(Class<T> clz){
        return (T) Enhancer.create(clz,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
