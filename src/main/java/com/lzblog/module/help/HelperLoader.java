package com.lzblog.module.help;

import com.lzblog.module.util.ClassUtil;

/**
 * 加载helper类
 * Created by lz on 2016/11/18.
 */
public final class HelperLoader {

    public static void init() {
        Class<?> [] classList = {
            ClassHelper.class,
            BeanHelper.class,
            IocHelper.class,
            ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),false);
        }
    }
}
