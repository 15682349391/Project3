package com.wangli.web;

import com.google.gson.Gson;
import com.wangli.pojo.Book;
import com.wangli.pojo.Cart;
import com.wangli.pojo.CartItem;
import com.wangli.service.BookService;
import com.wangli.service.impl.BookServiceImpl;
import com.wangli.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.web
 * @ClassName: CartServlet
 * @Author: 38272
 * @Description: 购物车的实现
 * @Date: 2020/5/8 12:50
 * @Version: 1.0
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);

        System.out.println(cart);

        //resp.sendRedirect(req.getContextPath()); //不能实现跳转

        System.out.println(req.getHeader("Referer"));

        resp.sendRedirect(req.getHeader("Referer"));

        req.getSession().setAttribute("lastName", cartItem.getName());

    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = bookService.queryBookById(id);

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);

        System.out.println(cart);

        //resp.sendRedirect(req.getContextPath()); //不能实现跳转

        /*System.out.println(req.getHeader("Referer"));

        resp.sendRedirect(req.getHeader("Referer"));*/

        req.getSession().setAttribute("lastName", cartItem.getName());

        Integer totalCount = cart.getTotalCount();
        String lastName = cartItem.getName();

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("totalCount", totalCount);
        resultMap.put("lastName", lastName);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);


    }

        protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int count = WebUtils.parseInt(req.getParameter("count"), 0);

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}