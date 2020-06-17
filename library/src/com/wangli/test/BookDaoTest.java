package com.wangli.test;

import com.wangli.dao.BookDao;
import com.wangli.dao.impl.BookDaoImpl;
import com.wangli.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.test
 * @ClassName: BookDaoTest
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 21:02
 * @Version: 1.0
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "test", "test", "laownag","aa12", 23, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.addBook(new Book(2, "test", "test", "laownag","aa12", 23, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for(Book queryBooks : books){
            System.out.println(queryBooks);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(8, 4);
        for(Book booksQuery: books){
            System.out.println(booksQuery);
        }

    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(0, 8,10, 50);
        for(Book booksQuery: books){
            System.out.println(booksQuery);
        }

    }
}