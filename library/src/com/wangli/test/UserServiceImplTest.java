package com.wangli.test;

import com.wangli.pojo.User;
import com.wangli.service.UserService;
import com.wangli.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.test
 * @ClassName: UserServiceImplTest
 * @Author: 38272
 * @Description:
 * @Date: 2020/4/27 9:42
 * @Version: 1.0
 */

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null, "lw123", "123456", "382720@qq.com","",""));
    }

    @Test
    public void logon() {

        if(userService.login(new User(null, "admin", "admin1", "null", "","")) == null){
            System.out.println("登录失败，检查用户名或密码是否错误。");
        } else{
            System.out.println("登录成功。");
        }
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("admin2")){
            System.out.println("用户名已存在。");
        } else{
            System.out.println("用户名可用。");
        }
    }
}