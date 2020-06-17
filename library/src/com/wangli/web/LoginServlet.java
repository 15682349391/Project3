package com.wangli.web;

import com.wangli.pojo.User;
import com.wangli.service.UserService;
import com.wangli.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: Project2
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 38272
 * @Description: ${description}
 * @Date: 2020/4/27 11:48
 * @Version: 1.0
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User login = userService.login(new User(null, username, password, null,null,null));

        if(login == null){
            System.out.println("登陆失败");
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            System.out.println(username + "登录成功！");
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
