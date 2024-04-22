package com.ztc.smart.farmework.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName CollectionUtils
 * @Description 集合的工具类
 * @Author ztc
 * @Date 2024/4/20 16:44
 */
public final class CollectionUtil {

    public static boolean mapIsEmpty(Map map){
       return MapUtils.isEmpty(map);
    }

    public static boolean mapIsNotEmpty(Map map){
        return MapUtils.isNotEmpty(map);
    }

    public static boolean collectionIsEmpty(Collection coll){
        return CollectionUtils.isEmpty(coll);
    }

    public static boolean collectionIsNotEmpty(Collection coll){
        return CollectionUtils.isNotEmpty(coll);
    }
}
