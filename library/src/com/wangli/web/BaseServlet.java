package com.wangli.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.web
 * @ClassName: BaseServlet
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 16:23
 * @Version: 1.0
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");

        if (action != null) {
            try {
                //使用反射调用方法
                Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);

                //System.out.println(method);

                method.invoke(this,req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("注意：指向的servlet的地址无action参数");
        }

    }
}
