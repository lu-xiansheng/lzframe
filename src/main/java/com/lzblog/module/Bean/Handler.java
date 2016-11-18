package com.lzblog.module.Bean;

import java.lang.reflect.Method;

/**
 *
 * Created by lz on 2016/11/18.
 */
public class Handler {

    private Class<?> controllerClass; //Controller类
    private Method actionMethod;      //Action方法

    public Handler(Class<?> controllerClass,Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

}
