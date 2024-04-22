package com.ztc.smart.farmework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName CodeUtil
 * @Description 编码与解码操作类
 * @Author ztc
 * @Date 2024/4/22 9:32
 */
public final class CodeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeUtil.class);

    /***
     * @Author ztc
     * @Description url编码
     * @Date 2024/4/22
     * @param source
     * @return java.lang.String
     *
     **/
    public static String encodeUrl(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /***
     * @Author ztc
     * @Description url解码
     * @Date 2024/4/22
     * @param source
     * @return java.lang.String
     *
     **/
    public static String decodeUrl(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("decode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
