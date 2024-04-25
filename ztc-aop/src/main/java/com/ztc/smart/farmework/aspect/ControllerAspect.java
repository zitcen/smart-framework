package com.ztc.smart.farmework.aspect;

import com.ztc.smart.farmework.annotation.Aspect;
import com.ztc.smart.farmework.annotation.Controller;
import com.ztc.smart.farmework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @ClassName ControllerAspect
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/25 10:17
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void before(Class<?> clz, Method method, Object[] params) throws Throwable {
       LOGGER.debug("------------begin------------");
       LOGGER.debug(String.format("class: %s",clz.getName()));
       LOGGER.debug(String.format("method: %s",method.getName()));
       begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> clz, Method method, Object[] params) throws Throwable {

        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("------------end------------");
    }
}
