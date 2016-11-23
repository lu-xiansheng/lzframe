package com.lzblog.module.Bean;

/**返回数据对象
 * Created by lz on 2016/11/18.
 */
public class Data {

    private Object model; //模型数据

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
