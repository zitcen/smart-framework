package com.ztc.smart.farmework.helper;

import com.ztc.smart.farmework.ConfigConstant;
import com.ztc.smart.farmework.util.PropsUtil;

import java.util.Properties;

/**
 * @ClassName ConfigHelper
 * @Description 辅助读取配置文件的类
 * @Author ztc
 * @Date 2024/4/19 11:07
 */
public class ConfigHelper {

    private static final Properties CONFIG_PROP
            = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /***
     * @Author ztc
     * @Description 获取JDBC的驱动
     * @Date 2024/4/19
     * @return java.lang.String
     *
    **/
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROP,ConfigConstant.JDBC_DRIVER);
    }

    /***
     * @Author ztc
     * @Description 获取JDBC URL
     * @Date 2024/4/19
     * @return java.lang.String
     *
     **/
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROP,ConfigConstant.JDBC_URL);
    }

    /***
     * @Author ztc
     * @Description 获取JDBC 用户名
     * @Date 2024/4/19
     * @return java.lang.String
     *
     **/
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROP,ConfigConstant.JDBC_USERNAME);
    }

    /***
     * @Author ztc
     * @Description 获取JDBC 密码
     * @Date 2024/4/19
     * @return java.lang.String
     *
     **/
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROP,ConfigConstant.JDBC_PASSWORD);
    }

    /***
     * @Author ztc
     * @Description 获取应用基础包名
     * @Date 2024/4/19
     * @return java.lang.String
     *
     **/
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROP,ConfigConstant.APP_BASE_PACKAGE);
    }

    /***
     * @Author ztc
     * @Description 获取 JSP 路径
     * @Date 2024/4/19
     * @return java.lang.String
     *
     **/
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROP,ConfigConstant.APP_JSP_PATH);
    }

    /***
     * @Author ztc
     * @Description 静态资源路径
     * @Date 2024/4/19
     * @return java.lang.String
     *
     **/
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROP,ConfigConstant.APP_ASSET_PATH);
    }
}
