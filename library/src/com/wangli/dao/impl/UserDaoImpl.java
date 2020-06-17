package com.wangli.dao.impl;

import com.wangli.dao.UserDao;
import com.wangli.pojo.User;
import org.junit.Test;
import sun.security.util.Password;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`, `username`, `password`, `email` , `userid` ,`regdate`from t_user where username = ?";
        return queryForOne(sql, User.class, username);

    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? and password = ?";
        return queryForOne(sql, User.class, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`userid`,`password`,`email`,`regdate`) values(?,?,?,?,?)";
        return update(sql, user.getUsername(), user.getUserid(), user.getPassword(), user.getEmail(), user.getRegdate());
    }

    @Test

    public void test(){
        String l = new String(String.valueOf(new Date().getTime()));
        System.out.println(l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
        String date = sdf.format(new Date());
        System.out.println(date);
    }
}
