package com.ztc.smart.farmework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @ClassName AspectProxy
 * @Description 切面代理
 * @Author ztc
 * @Date 2024/4/25 9:27
 */
public abstract class AspectProxy implements Proxy{

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> clz = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(clz,method,params)) {
                before(clz,method,params);
                result = proxyChain.doProxyChain();
                after(clz,method,params);
            }else{
                result = proxyChain.doProxyChain();
            }

        } catch (Throwable e) {
            LOGGER.error("proxy failure", e);
            error(clz,method,params);
        } finally {
            end();
        }
        return result;
    }

    public void begin(){}

    public boolean intercept(Class<?> clz, Method method, Object[] params) throws Throwable{
        return true;
    }

    public void before(Class<?> clz, Method method, Object[] params) throws Throwable{
    }

    public void after(Class<?> clz, Method method, Object[] params) throws Throwable{
    }

    public void error(Class<?> clz, Method method, Object[] params) throws Throwable{
    }

    public void end(){}

}
