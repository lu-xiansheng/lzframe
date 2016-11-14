package com.lzblog.module.help;

import com.lzblog.module.entity.Customer;
import com.lzblog.module.util.PropsUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库助手类
 * Created by lz on 2016/11/14.
 */
public class DataBaseHelper {

    private static final Logger logger = Logger.getLogger(Customer.class);

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL =
            new ThreadLocal<Connection>();

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    static {
        Properties conf = PropsUtil.loadPrope("jdbc.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.error("can't load jdbc driver",e);
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection connect = CONNECTION_THREAD_LOCAL.get();
        if(connect == null) {
            try {
                connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
}
