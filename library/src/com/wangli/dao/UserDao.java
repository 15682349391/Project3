package com.wangli.dao;

import com.wangli.pojo.User;


public interface UserDao {

    /*
    * @description
    * @param null
    * @return     返回null表示不存在
    * @exception
    * @author      hedong
    * @date
    **/
    public User queryUserByUsername(String username);


    public User queryUserByUsernameAndPassword(String username,String password);


    public int saveUser(User user);

}
