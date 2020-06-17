package com.wangli.dao.impl;

import com.wangli.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql,Object ... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();//使用Thread后一定要抛异常，否则调用无法捕获异常使事务回滚
        } /*finally {
            JDBCUtils.closeConnection(conn);
            使用ThreadLocal后连接不能关闭，否则后面用的连接对象不在一个线程中。
        }*/
    }
    public <T> T queryForOne(String sql,Class<T> T,Object ... args){

        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new

        BeanHandler<T>(T),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();//使用Thread后一定要抛异常，否则调用无法捕获异常使事务回滚
        } /*finally {
            JDBCUtils.closeConnection(conn);
            使用ThreadLocal后连接不能关闭，否则后面用的连接对象不在一个线程中。
        }
*/
    }


    
    public <T>List<T> queryForList(Class<T>T,String sql,Object ...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(T), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();//使用Thread后一定要抛异常，否则调用无法捕获异常使事务回滚
        } /*finally {
            JDBCUtils.closeConnection(conn);
            使用ThreadLocal后连接不能关闭，否则后面用的连接对象不在一个线程中。
        }*/
    }



    public Object queryForSingleValue(String sql, Object ...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();//使用Thread后一定要抛异常，否则调用无法捕获异常使事务回滚
        } /*finally {
            JDBCUtils.closeConnection(conn);
        }*/
    }

}
