package com.wangli.web;

import com.wangli.pojo.Book;
import com.wangli.pojo.Page;
import com.wangli.service.BookService;
import com.wangli.service.impl.BookServiceImpl;
import com.wangli.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.web
 * @ClassName: ClientServlet
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/5 19:02
 * @Version: 1.0
 */
public class ClientServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("经过了前台的pageByPrice");

        //处理分页
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer min = WebUtils.parseInt(req.getParameter("min"), 0);
        Integer max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        //自己的方法
        //page.setUrl("client/bookServlet?action=pageByPrice&min="+req.getParameter("min")+"&max="+req.getParameter("max"));

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());


        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //System.out.println("经过了前台的servlet");

        //处理分页
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");



        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
