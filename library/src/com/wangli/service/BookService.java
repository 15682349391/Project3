package com.wangli.service;

import com.wangli.pojo.Book;
import com.wangli.pojo.Page;

import java.util.List;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.service.impl
 * @ClassName: BookService
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 22:05
 * @Version: 1.0
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
