package com.ztc.smart.farmework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionUtil
 * @Description 通过反射工具来创建实例
 * @Author ztc
 * @Date 2024/4/20 10:11
 */
public final class ReflectionUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /***
     * @Author ztc
     * @Description 初始化实例
     * @Date 2024/4/20
     * @param clz
     * @return java.lang.Object
     *
    **/
    public static Object  newInstance(Class<?> clz){
        Object instance;
        try {
            instance = clz.newInstance();
        } catch (Exception e) {
           LOGGER.error("new instance failure",e);
           throw new RuntimeException(e);
        }
        return instance;
    }

    /***
     * @Author ztc
     * @Description 调用实例的方法
     * @Date 2024/4/20
     * @param obj
     * @param method
     * @param args
     * @return java.lang.Object
     * 
    **/
    public static Object invokeMethod(Object obj, Method method,Object... args){
        Object result;
        try {
            result = method.invoke(obj,args);
        } catch (Exception e) {
           LOGGER.error("invoke method failure",e);
           throw new RuntimeException(e);
        }
        return result;
    }

    /***
     * @Author ztc
     * @Description 给实例的成员变量赋值
     * @Date 2024/4/20
     * @param obj
     * @param field
     * @param value
     *
    **/
    public static void setField(Object obj, Field field, Object value){
        field.setAccessible(false);
        try {
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
