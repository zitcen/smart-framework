package com.ztc.smart.farmework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ClassUtil
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/19 14:50
 */
public final class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CastUtil.class);

    /***
     * @Author ztc
     * @Description 获取类加载器
     * @Date 2024/4/19
     * @return java.lang.ClassLoader
     *
     **/
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /***
     * @Author ztc
     * @Description 加载类,为提高加载类的性能，可以将loadClass 方法的 isInitialized 参数设置为false
     * @Date 2024/4/19
     * @param className
     * @param isInitialized
     * @return java.lang.Class<?>
     *
     **/
    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> clz;
        try {
            clz = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("load class failue", e);
            throw new RuntimeException(e);
        }
        return clz;
    }

    /***
     * @Author ztc
     * @Description 获取包名下面的所有类
     * @Date 2024/4/19
     * @param packageName
     * @return java.util.Set<java.lang.Class<?>>
     *
    **/
    public static Set<Class<?>> getClassSet(String packageName) {
        HashSet<Class<?>> classSet = new HashSet<>();
        URL url = getClassLoader().getResource(packageName.replace(".", "/"));
        File classDir = new File(url.getFile());
        File[] files = classDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getClassSet(packageName+"."+file.getName());
            }else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }else{
                    String clazzName = (packageName + "." + file.getName());
                    doAddClass(classSet,clazzName);
                }
            }
        }
        return classSet;
    }

    private static void  doAddClass(Set<Class<?>> classSet,String clazzName){
        Class<?> aClass = loadClass(clazzName, false);
        classSet.add(aClass);
    }
}
