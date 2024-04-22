package com.ztc.smart.farmework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName View
 * @Description 返回视图对象
 * @Author ztc
 * @Date 2024/4/21 21:40
 */
public class View {
    
    /***
     * @Author ztc
     * @Description 视图路径
     * @Date 2024/4/21  
     * @param null 
     * @return null
     * 
    **/
    private String path;

    /***
     * @Author ztc
     * @Description 模型数据
     * @Date 2024/4/21
     * @param null 
     * @return null
     * 
    **/
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public View addModel(String key, Object value){
        model.put(key,value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
