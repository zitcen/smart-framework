package com.ztc.smart.farmework.proxy;

/**
 * @ClassName 代理接口
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/24 17:05
 */
public interface Proxy {
    /***
     * @Author ztc
     * @Description 执行链式代理
     * @Date 2024/4/24
     * @param proxyChain
     * @return java.lang.Object
     *
    **/
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
