package com.wangli.web;

import com.google.gson.Gson;
import com.wangli.pojo.User;
import com.wangli.service.UserService;
import com.wangli.service.impl.UserServiceImpl;
import com.wangli.test.UserServletTest;
import com.wangli.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.web
 * @ClassName: UserServlet
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 13:34
 * @Version: 1.0
 */
public class UserServlet extends BaseServlet {

    private UserService userService= new UserServiceImpl();

        protected void ajaxExistUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            


            String username = request.getParameter("username");

            boolean existUsername = userService.existUsername(username);

            Map<String,Object> map = new HashMap<>();

            map.put("existUsername", existUsername);

            Gson gson = new Gson();

            String json = gson.toJson(map);

            response.getWriter().write(json);

        }

        protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //删除用户登录的session
            request.getSession().invalidate();
            //返回首页
            response.sendRedirect(request.getContextPath()+ "/index.jsp");

        }
        protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                //设置用户登录之后的session信息
                request.getSession().setAttribute("user",login);
                request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
            }
        }

        protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String code = request.getParameter("code");
            String userid = String.valueOf(new Date().getTime());
            String regdate = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒").format(new Date());

            User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());

            String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
            request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

            if(token != null && token.equalsIgnoreCase(code)){


                if(userService.existUsername(username)){
                    request.setAttribute("msg","用户名已存在！！");
                    request.setAttribute("username",username);
                    request.setAttribute("email",email);
                    System.out.println("用户名" +username+ "已存在");
                    request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
                } else {
                    userService.registUser(new User(null, username, password, email,userid,regdate));
                    System.out.println("用户" + username + "注册");
                    request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
                }
            } else if (token == null) {
                request.setAttribute("msg","、重复提交！！");
                System.out.println("重复提交");
            } else {
                request.setAttribute("msg","验证码错误！！");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                System.out.println("验证码"+ code + "错误");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }

        }
    }

