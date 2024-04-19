package com.ztc.smart.farmework.helper;

import com.ztc.smart.farmework.util.ClassUtil;

import java.util.Set;

/**
 * @ClassName ClassHelper
 * @Description 类操作助手类
 * @Author ztc
 * @Date 2024/4/19 16:51
 */
public class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /***
     * @Author ztc
     * @Description 获取应用包名下所有的类
     * @Date 2024/4/19
     * @return java.util.Set<java.lang.Class<?>>
     *
    **/
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }
}
