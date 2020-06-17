package com.wangli.web;

import com.wangli.dao.impl.BaseDao;
import com.wangli.pojo.Cart;
import com.wangli.pojo.User;
import com.wangli.service.OrderService;
import com.wangli.service.impl.OrderServiceImpl;
import com.wangli.utils.JDBCUtils;
import com.wangli.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.web
 * @ClassName: OrderServlet
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/9 0:28
 * @Version: 1.0
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        Cart cart = (Cart) req.getSession().getAttribute("cart");

        User userLogin = (User) req.getSession().getAttribute("user");



        if (userLogin == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            //return终止执行
            return;
        }

        Integer id = userLogin.getId();

        String orderId = null;

        orderId = orderService.createOrder(cart, id);


      /*    使用filter统一处理事务后就不要了
      //使用ThreadLocal对调用进行try/catch，捕获到异常后事务回滚。
        try {



            JDBCUtils.commitAndClose();//无异常提交事务。

        } catch (Exception e) {
            e.printStackTrace();

            JDBCUtils.rollbackAndClose();//有异常回滚事务。
        }*/

        //req.setAttribute("orderId",orderId);

        System.out.println((orderId == null));

        req.getSession().setAttribute("orderId",orderId);

        //使用重定向，避免用户刷新重复提交。
        //req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        resp.sendRedirect( req.getContextPath() + "/pages/cart/checkout.jsp");

    }
}
