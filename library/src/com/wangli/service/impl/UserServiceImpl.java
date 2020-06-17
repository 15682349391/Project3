package com.wangli.service.impl;

import com.wangli.dao.UserDao;
import com.wangli.dao.impl.UserDaoImpl;
import com.wangli.pojo.User;
import com.wangli.service.UserService;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.service.impl
 * @ClassName: UserServiceImpl
 * @Author: 38272
 * @Description: 用于service业务用的
 * @Date: 2020/4/27 9:31
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
