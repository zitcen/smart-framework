package com.ztc.smart.farmework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

/**
 * @ClassName Request
 * @Description 封装请求信息
 * @Author ztc
 * @Date 2024/4/21 11:01
 */
public class Request {

    /***
     * @Author ztc
     * @Description 请求方法
     * @Date 2024/4/21
     * @param null
     * @return null
     *
    **/
    private String requestMethod;


    /***
     * @Author ztc
     * @Description 请求路径
     * @Date 2024/4/21
     * @param null 
     * @return null
     * 
    **/
    private String requestPath;

    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj);
    }
}
