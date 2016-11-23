package com.lzblog.module.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**流操作工具类
 * Created by lz on 2016/11/18.
 */
public final class StreamUtil {

    private static final Logger logger = Logger.getLogger(StreamUtil.class);

    public static String getString(InputStream is) {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            logger.error("get string failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
