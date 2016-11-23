package com.lzblog.module.Bean;

import com.lzblog.module.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by lz on 2016/11/18.
 */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String,Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数获取long型参数
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return
     */
    public Map<String,Object> getMap() {
        return paramMap;
    }
}
