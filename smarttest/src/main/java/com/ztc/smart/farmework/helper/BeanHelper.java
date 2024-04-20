package com.ztc.smart.farmework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName BeanHelper
 * @Description 将放到容器中的Bean进行实例化，并放到容器中去
 * @Author ztc
 * @Date 2024/4/20 10:54
 */
public class BeanHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(BeanHelper.class);
    /**
     * Bean的容器，用于存放bean类和与其对应的实例
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    //初始化容器，并将bean放到容器中
    static {
        Set<Class<?>> beanClass = ClassHelper.getBeanClass();
        for (Class<?> aClass : beanClass) {
            Object obj = ReflectionUtil.newInstance(aClass);
            BEAN_MAP.put(aClass,obj);
        }
    }

    /***
     * @Author ztc
     * @Description 获取BeanMap
     * @Date 2024/4/20
     * @return java.util.Map<java.lang.Class<?>,java.lang.Object>
     *
    **/
    public static Map<Class<?>, Object> getBeanMap(){
        return BEAN_MAP;
    }

    /***
     * @Author ztc
     * @Description 根据bean的类型获取Bean的实例
     * @Date 2024/4/20
     * @param clz
     * @return T
     *
    **/
    public static <T> T getBean(Class clz){
        if (BEAN_MAP.containsKey(clz)) {
            LOGGER.error("can not get bean by class" + clz);
        }
        return (T)BEAN_MAP.get(clz);
    }
}
