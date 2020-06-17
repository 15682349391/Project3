package com.wangli.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    private static DruidDataSource dataSource;

    static {
        try {
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties prop = new Properties();
            prop.load(inputStream);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);


            DruidPooledConnection connection = dataSource.getConnection();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static Connection getConnection(){


        Connection conn = connectionThreadLocal.get();

        if (conn == null) {

            try {

                //从数据库连接池中获取连接
                conn = dataSource.getConnection();

                //保存到ThreadLocal中
                connectionThreadLocal.set(conn);

                //设置手动管理
                conn.setAutoCommit(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;

    }

    /*
    *提交事务并关闭连接
    **/

    public static void commitAndClose() {

        Connection conn = connectionThreadLocal.get();//获取当前线程中的Connection对象

        if(conn != null) {
            try {
                conn.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //使用remove移除当前线程中的对象，否则出错，因为Tomcat底层使用了线程池技术
        connectionThreadLocal.remove();

    }

    public static void rollbackAndClose() {
        Connection conn = connectionThreadLocal.get();//获取当前线程中的Connection对象

        if(conn != null) {
            try {
                conn.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //使用remove移除当前线程中的对象，否则出错，因为Tomcat底层使用了线程池技术
        connectionThreadLocal.remove();
    }


    /*public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
}
