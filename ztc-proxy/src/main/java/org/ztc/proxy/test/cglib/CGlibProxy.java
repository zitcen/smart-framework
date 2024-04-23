package org.ztc.proxy.test.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CGlibProxy
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/23 9:11
 */
public class CGlibProxy implements MethodInterceptor {
    private static CGlibProxy instance = new CGlibProxy();
    private CGlibProxy(){

    }

    public static CGlibProxy getInstance(){
        return instance;
    }
    public <T> T getProxy(Class<T> clz){
        return (T)Enhancer.create(clz,this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        before();
        Object result = methodProxy.invokeSuper(obj, args);
        after();
        return result;
    }


    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }
}
