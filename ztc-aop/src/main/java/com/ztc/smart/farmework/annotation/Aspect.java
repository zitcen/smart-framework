package com.ztc.smart.farmework.annotation;

import java.lang.annotation.*;

/***
 * @Author ztc
 * @Description 切面注解
 * @Date 2024/4/24
 *
**/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     * @return
     */
    Class<? extends Annotation> value();
}
