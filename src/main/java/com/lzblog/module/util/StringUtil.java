package com.lzblog.module.util;

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
        return StringUtil.isEmpty(str);
    }

    /**
     * 判断字符串是否为非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
