package com.wangli.test;

import com.alibaba.druid.util.JdbcUtils;
import com.wangli.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void jdbcConnectionTest(){
        for (int i = 0; i < 100; i++) {
            Connection conn = JDBCUtils.getConnection();
            System.out.println(conn);
            System.out.println(Thread.currentThread().getName());
            JDBCUtils.commitAndClose();

        }
    }



}
