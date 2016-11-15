package com.lzblog.module.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * Created by lz on 2016/11/15.
 */
public class ArrayUtil {

    /**
     * 判断数组是否为非空
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
