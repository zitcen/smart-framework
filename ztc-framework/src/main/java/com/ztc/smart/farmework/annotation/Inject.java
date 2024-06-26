package com.ztc.smart.farmework.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * @Author ztc
 * @Description 依赖注入注解
 * @Date 2024/4/19
 * @return null
 *
**/
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
