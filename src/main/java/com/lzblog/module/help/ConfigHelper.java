package com.lzblog.module.help;

import com.lzblog.module.util.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * Created by lz on 2016/11/14.
 */
public class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadPrope
            (ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     * @return
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取 jdbc url
     * @return
     */
    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBA_URL);
    }

    /**
     * 获取 jdbc username
     * @return
     */
    public static String getJdbcUsername() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取 jdbc password
     * @return
     */
    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     * @return
     */
    public static String getAppBasePath() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PATH);
    }

    /**
     * 获取jsp文件路径
     * @return
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/jsp/");
    }

    /**
     * 获取静态资源路径
     * @return
     */
    public static String getAppStaticPath() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_STATIC_PATH,"/static/");
    }
}