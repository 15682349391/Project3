package com.wangli.dao;

import com.wangli.pojo.Book;

import java.util.List;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.dao
 * @ClassName: BookDao
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 20:28
 * @Version: 1.0
 */
public interface BookDao {

    public int addBook(Book book);

    public  int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(Integer min, Integer max);

    List<Book> queryForPageItemsByPrice(int begin, Integer pageSize, Integer min, Integer max);
}

