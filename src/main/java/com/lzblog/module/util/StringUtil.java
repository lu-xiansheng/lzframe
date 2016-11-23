package com.lzblog.module.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * Created by lz on 2016/11/12.
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if(str != null) {
           str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否为非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String[] splitString(String str, String s) {
        if (isNotEmpty(str)) {
            return str.split("&");
        }
        return null;
    }
}
