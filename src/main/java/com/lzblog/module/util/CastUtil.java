package com.lzblog.module.util;

/**
 * 转型操作工具类
 * Created by lz on 2016/11/11.
 */
public final class CastUtil {

    /**
     * 转为string类
     * @param obj
     * @return
     */
    public static String castSting(Object obj) {
        return CastUtil.castSting(obj,"");
    }

    private static String castSting(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转化为double
     * @param obj
     * @return
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj,0);
    }

    private static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if(obj != null) {
            String strValue = castSting(obj);
            if(StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转化为long类型
     * @param obj
     * @return
     */
    public static long castLong(Object obj) {
        return castLong(obj,0);
    }

    private static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if(obj != null) {
            String strValue = castSting(obj);
            if(StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转化为int类型
     * @param obj
     * @return
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj,0);
    }

    private static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if(obj != null) {
            String strValue = castSting(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转化为boolean型
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj) {

        return castBoolean(obj,false);
    }

    private static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if(obj != null) {
            String strValue = castSting(obj);
            if(StringUtil.isNotEmpty(strValue)) {
                try {
                    booleanValue = Boolean.parseBoolean(strValue);
                }  catch (NumberFormatException e) {
                    booleanValue = defaultValue;
                }
            }
        }
        return booleanValue;
    }
}
