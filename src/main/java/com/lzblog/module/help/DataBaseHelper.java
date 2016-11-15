package com.lzblog.module.help;

import com.lzblog.module.entity.Customer;
import com.lzblog.module.util.PropsUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 数据库助手类
 * Created by lz on 2016/11/14.
 */
public class DataBaseHelper {

    private static final Logger logger = Logger.getLogger(Customer.class);

    /*private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;*/
    //线程池
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL;

    //Apache Commons Dbutils
    private static final QueryRunner QUERY_RUNNER;

    //数据库连接池
    private static final BasicDataSource DATA_SOURCE;

    static {
        CONNECTION_THREAD_LOCAL = new ThreadLocal<Connection>();

        QUERY_RUNNER = new QueryRunner();

        Properties conf = PropsUtil.loadPrope("lzframe.properties");
        String driver = conf.getProperty("jdbc.driver");
        String url = conf.getProperty("jdbc.url");
        String username = conf.getProperty("jdbc.username");
        String password = conf.getProperty("jdbc.password");

        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(driver);
        DATA_SOURCE.setUrl(url);
        DATA_SOURCE.setUsername(username);
        DATA_SOURCE.setPassword(password);
        /*try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("can't load jdbc driver",e);
        }*/
    }

    /**
     * 获取数据库连接
     * @return connect
     */
    public static Connection getConnection() {
        Connection connect = CONNECTION_THREAD_LOCAL.get();
        if(connect == null) {
            try {
                connect = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                logger.error("execute sql failure", e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_THREAD_LOCAL.set(connect);
            }
        }
        return connect;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        Connection connection = CONNECTION_THREAD_LOCAL.get();
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("close connection failure",e);
            } finally {
                CONNECTION_THREAD_LOCAL.remove();
            }
        }
    }

    /**
     * 查询实体
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T queryEntity(Class<T> entityClass,String sql,Object... params) {
        T entity = null;
        try {
            Connection connection = getConnection();
            entity = QUERY_RUNNER.query(connection,sql,new BeanHandler<T>(entityClass),params);
        } catch (SQLException e) {
            logger.error("query entity failure",e);
        } finally {
            closeConnection();
        }
        return entity;
    }

    /**
     * 增强型查询实体
     */
    public static List<Map<String,Object>> executeQuery(String sql, Object... params) {
        List<Map<String,Object>> result;
        try {
            Connection connection = getConnection();
            result = QUERY_RUNNER.query(connection,sql,new MapListHandler(),params);
        } catch (SQLException e) {
            logger.error("query entity failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }
}
