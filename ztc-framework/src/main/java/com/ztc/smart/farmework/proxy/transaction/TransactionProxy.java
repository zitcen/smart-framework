package com.ztc.smart.farmework.proxy.transaction;


import com.ztc.smart.farmework.annotation.Transaction;
import com.ztc.smart.farmework.helper.DatabaseHelper;
import com.ztc.smart.farmework.proxy.Proxy;
import com.ztc.smart.farmework.proxy.ProxyChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @ClassName TransactionProxy
 * @Description 事务代理
 * @Author ztc
 * @Date 2024/4/26 10:37
 */
public class TransactionProxy implements Proxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);
    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue(){
            return false;
        }

    };
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        Boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethod();
        if(!flag && method.isAnnotationPresent(Transaction.class)){
            FLAG_HOLDER.set(true);
            try {
                DatabaseHelper.beginTransaction();
                LOGGER.debug("start transaction");
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
                LOGGER.debug("commit transaction");
            } catch (Exception e) {
                DatabaseHelper.rollbackTransaction();
                LOGGER.debug("rollback transaction");
                throw e;
            } finally {
                FLAG_HOLDER.remove();
            }
        }else {
            result = proxyChain.doProxyChain();
        }

        return result;
    }
}
