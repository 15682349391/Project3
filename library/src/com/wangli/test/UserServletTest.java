package com.wangli.test;

import com.wangli.web.UserServlet;

import java.lang.reflect.Method;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.test
 * @ClassName: UserServletTest
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 15:27
 * @Version: 1.0
 */
public class UserServletTest {
    public static void main(String[] args) {
        String action = "regist";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);

            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void login(){
        System.out.println("login调用");
    }

    public void regist(){
        System.out.println("regist调用");
    }

    public void updateUser(){
        System.out.println("updateUser调用");
    }


}
