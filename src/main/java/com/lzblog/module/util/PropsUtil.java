package com.lzblog.module.util;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取jdbc配置文件
 * Created by lz on 2016/11/11.
 */
public final class PropsUtil {
    private static final Logger logger = Logger.getLogger(PropsUtil.class);

    public static Properties loadPrope(String fileName) {
        Properties properties = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(fileName);
            if(is == null) {
                throw new FileNotFoundException(fileName+"file is not found");
            }
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            logger.error("load properties files failure",e);
        } finally {
            if(is != null) {
                try {
                    is.close();
                }catch (IOException e) {
                    logger.error("close input stream failure",e);
                }
            }
        }
        return properties;
    }

    /**
     * 获取字符型属性
     * @param properties
     * @return
     */
    public static String getString(Properties properties,String key) {
        return getString(properties,key,"");
    }

    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if(properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性
     * @param properties
     * @param key
     * @return
     */
    public static int getInt(Properties properties,String key) {
        return getInt(properties,key,0);
    }

    private static int getInt(Properties properties, String key, int defaultValue) {
        int value = defaultValue;
        if(properties.containsKey(key)) {
            value = CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型属性
     * @param properties
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties properties,String key) {
        return getBoolean(properties,key,false);
    }

    private static boolean getBoolean(Properties properties, String key, Boolean defaultValue) {
        boolean value = defaultValue;
        if(properties.containsKey(key)) {
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return value;
    }

}
