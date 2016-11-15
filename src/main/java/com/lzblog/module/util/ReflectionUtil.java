package com.lzblog.module.util;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * Created by lz on 2016/11/15.
 */
public final class ReflectionUtil {

    private static final Logger logger = Logger.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        }catch (Exception e) {
            logger.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj,Method method,Object...args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        }catch (Exception e) {
            logger.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field,Object value) {
        field.setAccessible(true);
        try {
            field.set(obj,value);
        } catch (Exception e) {
            logger.error("set filed failure",e);
            throw new RuntimeException(e);
        }
    }
}
