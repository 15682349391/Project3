package com.wangli.web;

import com.wangli.pojo.Book;
import com.wangli.pojo.Page;
import com.wangli.service.BookService;
import com.wangli.service.impl.BookServiceImpl;
import com.wangli.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.web
 * @ClassName: BookServlet
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 22:42
 * @Version: 1.0
 */
public class BookServlet extends BaseServlet {


    BookService bookService = new BookServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        bookService.addBook(book);

        //req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        bookService.deleteBookById(id);

        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);

        Book book = bookService.queryBookById(id);

        req.setAttribute("book",book);

        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }



    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        bookService.updateBook(book);

        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1通过bookService查询全部图书
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理分页
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("bookServlet?action=page");

        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
