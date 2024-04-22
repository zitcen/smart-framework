package com.ztc.smart.farmework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName StreamUtil
 * @Description 流的工具类
 * @Author ztc
 * @Date 2024/4/22 9:15
 */
public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /***
     * @Author ztc
     * @Description 从流中获取字符串
     * @Date 2024/4/22
     * @param is
     * @return java.lang.String
     *
    **/
    public static String  getString(InputStream is){
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            LOGGER.error("get String failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
