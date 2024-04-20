package com.ztc.smart.farmework.helper;

import com.ztc.smart.farmework.annotation.Inject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName IocHelper
 * @Description 辅助框架进行依赖注入类
 * @Author ztc
 * @Date 2024/4/20 16:02
 */
public class IocHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(IocHelper.class);
    static {
        //获取所有实例，并清理出实例之间的关系
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(!beanMap.isEmpty()){
            Set<Map.Entry<Class<?>, Object>> entries = beanMap.entrySet();
            //遍历 beanMap
            for (Map.Entry<Class<?>, Object> entry : entries) {
                // 从 beanMap 中获取 Bean 类和 Bean 实例
                Class<?> clz = entry.getKey();
                Object obj = entry.getValue();
                // 获取 bean 定义的所有成员变量
                Field[] fields = clz.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(fields)){
                    // 遍历所有的成员变量
                    for (Field beanField : fields) {
                        //判断成员变量是否需要依赖注入
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<? extends Field> fieldClass = beanField.getClass();
                            //在beanMap中获取对应的实例,并对成员变量赋值
                            Object beanFieldInstance = beanMap.get(fieldClass);
                            if(!Objects.isNull(beanFieldInstance)){
                                ReflectionUtil.setField(obj, beanField, beanFieldInstance);
                            }else{
                                LOGGER.error("bean is not found :" ,fieldClass);
                            }
                        }
                    }
                }

            }
        }

    }
}
