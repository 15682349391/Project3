package com.wangli.web;

import com.wangli.pojo.User;
import com.wangli.service.UserService;
import com.wangli.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: Project2
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 38272
 * @Description: ${description}
 * @Date: 2020/4/27 10:32
 * @Version: 1.0
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String userid = String.valueOf(new Date().getTime());
        String regdate = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒").format(new Date());

        if("aA".equalsIgnoreCase(code)){
            if(userService.existUsername(username)){
                request.setAttribute("msg","用户名已存在！！");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                System.out.println("用户名" +username+ "已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                userService.registUser(new User(null, username, password, email, userid, username));
                System.out.println("用户" + username + "注册");
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("msg","验证码错误！！");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            System.out.println("验证码"+ code + "错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
