package com.wangli.test;

import com.wangli.dao.UserDao;
import com.wangli.dao.impl.UserDaoImpl;
import com.wangli.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("laowang"));

        if(userDao.queryUserByUsername("admin1") != null){
            System.out.println("用户不可用");
        }else {
            System.out.println("用户已存在。");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));
        if(userDao.queryUserByUsernameAndPassword("admin", "admin") == null){
            System.out.println("用户或密码错误！");
        } else{
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.saveUser(new User(null, "laowang2", "123456", "382720942@qq.com","asdf","asdfd"));
        System.out.println(i);
    }
}