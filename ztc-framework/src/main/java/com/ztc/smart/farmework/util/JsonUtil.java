package com.ztc.smart.farmework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @ClassName JsonUtil
 * @Description JSON 工具类
 * @Author ztc
 * @Date 2024/4/22 9:41
 */
public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /***
     * @Author ztc
     * @Description 将对象转换成json字符串
     * @Date 2024/4/22
     * @param obj
     * @return java.lang.String
     *
     **/
    public static <T> String toJson(T obj) {
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("convert POJO to Json failure",e);
            throw new RuntimeException(e);
        }
        return json;
    }

    /***
     * @Author ztc
     * @Description 将json字符串对象转换成对象
     * @Date 2024/4/22
     * @param json
     * @param clz
     * @return java.lang.String
     *
     **/
    public static <T> T toJson(String json, Class<T> clz) {
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json, clz);
        } catch (IOException e) {
            LOGGER.error("convert JSON to POJO failure",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }

}
