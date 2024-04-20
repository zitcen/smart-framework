package com.ztc.smart.farmework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @ClassName ArrayUtil
 * @Description 数组工具
 * @Author ztc
 * @Date 2024/4/20 16:42
 */
public final class ArrayUtil {
    public static boolean isNotEmpty(Object[] array){
        return ArrayUtils.isNotEmpty(array);
    }

    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
}
