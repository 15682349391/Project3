package com.wangli.test;

import com.wangli.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void jdbcConnectionTest(){
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            System.out.println(Thread.currentThread().getName());

        }
    }



}
