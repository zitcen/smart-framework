package com.ztc.smart.farmework.bean;

import java.lang.reflect.Method;

/**
 * @ClassName Handler
 * @Description 封装Action信息
 * @Author ztc
 * @Date 2024/4/21 11:07
 */
public class Handler {

    /***
     * @Author ztc
     * @Description controller 类
     * @Date 2024/4/21
     * @param null
     * @return null
     *
    **/
    private Class<?> controllerClass;

    /***
     * @Author ztc
     * @Description action 方法
     * @Date 2024/4/21
     * @param null 
     * @return null
     * 
    **/
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
