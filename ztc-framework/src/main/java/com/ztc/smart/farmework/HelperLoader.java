package com.ztc.smart.farmework;

import com.ztc.smart.farmework.helper.*;
import com.ztc.smart.farmework.util.ClassUtil;

/**
 * @ClassName 初始化框架
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/21 13:45
 */
public class HelperLoader {
    public static void init(){
        Class<?>[] classList= {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class,
                AopHelper.class
        };
        for (Class<?> clz : classList) {
            ClassUtil.loadClass(clz.getName(), true);
        }
    }
}
