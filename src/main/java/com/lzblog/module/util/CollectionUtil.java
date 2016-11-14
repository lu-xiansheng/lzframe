package com.lzblog.module.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 * Created by lz on 2016/11/12.
 */
public final class CollectionUtil {
    /**
     * 判断Collection是否为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断collection是否非空
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
    /**
     * 判断Map是否为空
     * @param Map
     * @return
     */
    public static boolean isEmpty(Map<?,?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
     * 判断Map是否非空
     * @param Map
     * @return
     */
    public static boolean isNotEmpty(Map<?,?> map) {
        return !isEmpty(map);
    }
}
