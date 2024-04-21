package com.ztc.smart.farmework.bean;

import com.ztc.smart.farmework.util.CastUtil;

import java.util.Map;

/**
 * @ClassName Param
 * @Description TODO
 * @Author ztc
 * @Date 2024/4/21 21:05
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /***
     * @Author ztc
     * @Description 根据参数名称获取 long 型参数值
     * @Date 2024/4/21
     * @param name 
     * @return long
     * 
    **/
    public long getLong(String name){
       return CastUtil.castLong(paramMap.get(name));
    }

    /***
     * @Author ztc
     * @Description 获取所有字段信息
     * @Date 2024/4/21
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *
    **/
    public Map<String, Object> getMap(){
        return paramMap;
    }
}
