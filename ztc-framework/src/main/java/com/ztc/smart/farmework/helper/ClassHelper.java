package com.ztc.smart.farmework.helper;

import com.ztc.smart.farmework.annotation.Controller;
import com.ztc.smart.farmework.annotation.Service;
import com.ztc.smart.farmework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ClassHelper
 * @Description 类操作助手类
 * @Author ztc
 * @Date 2024/4/19 16:51
 */
public final class ClassHelper {
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

    /***
     * @Author ztc
     * @Description 获取包下面的所有 service
     * @Date 2024/4/20
     * @return java.util.Set<java.lang.Class<?>>
     *
    **/
    public static Set<Class<?>> getServiceClass(){
        Set<Class<?>> serviceClass = new HashSet<>();
        for (Class<?> clz : CLASS_SET) {
            if (clz.isAnnotationPresent(Service.class)) {
                serviceClass.add(clz);
            }
        }
        return serviceClass;
    }

    /***
     * @Author ztc
     * @Description 获取包下面的所有 controller
     * @Date 2024/4/20
     * @return java.util.Set<java.lang.Class<?>>
     *
     **/
    public static Set<Class<?>> getControllerClass(){
        Set<Class<?>> controllerClass = new HashSet<>();
        for (Class<?> clz : CLASS_SET) {
            if (clz.isAnnotationPresent(Controller.class)) {
                controllerClass.add(clz);
            }
        }
        return controllerClass;
    }

    /***
     * @Author ztc
     * @Description 获取包下面的所有 bean
     * @Date 2024/4/20
     * @return java.util.Set<java.lang.Class<?>>
     *
     **/
    public static Set<Class<?>> getBeanClass(){
        Set<Class<?>> beanClass = new HashSet<>();
        beanClass.addAll(getControllerClass());
        beanClass.addAll(getServiceClass());
        return beanClass;
    }

    /***
     * @Author ztc
     * @Description 获取应用包名下某父类或者接口的所有子类
     * @Date 2024/4/25  
     * @param superClass 
     * @return java.util.Set<java.lang.Class<?>>
     * 
    **/
    public static Set<Class<?>> getClassSetBuySuper(Class<?> superClass){
        HashSet<Class<?>> classSet = new HashSet<>();
        for (Class<?> clz : CLASS_SET) {
            if(superClass.isAssignableFrom(clz) && !superClass.equals(clz)){
                classSet.add(clz);
            }
        }
        return classSet;
    }
    
    /***
     * @Author ztc
     * @Description 获取应用包名下带有某注解的所有类
     * @Date 2024/4/25
     * @param annotation
     * @return java.util.Set<java.lang.Class<?>>
     * 
    **/
    public static Set<Class<?>> getClassSetBuyAnnotation(Class<? extends Annotation> annotation){
        HashSet<Class<?>> classSet = new HashSet<>();
        for (Class<?> clz : CLASS_SET) {
            if (clz.isAnnotationPresent(annotation)) {
                classSet.add(clz);
            }
        }
        return classSet;
    }
}
