package com.wangli.test;

import com.wangli.pojo.Book;
import com.wangli.pojo.Page;
import com.wangli.service.BookService;
import com.wangli.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: Project2
 * @Package: com.wangli.test
 * @ClassName: BookServiceTest
 * @Author: 38272
 * @Description:
 * @Date: 2020/5/3 22:26
 * @Version: 1.0
 */
public class BookServiceTest {

    private BookService bookService= new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "bookserviceTest", "laowang","LAOWANG", "45", 21, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);

    }

    @Test
    public void updateBook() {
        bookService.addBook(new Book(2, "bookserviceTest", "laowang","LAOWANG", "45", 21, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for(Book bookaQuery : books){
            System.out.println(bookaQuery);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}