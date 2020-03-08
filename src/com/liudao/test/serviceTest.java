package com.liudao.test;

import com.liudao.pojo.Book;
import com.liudao.service.BookService;
import com.liudao.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/4 - 10:17
 */
public class serviceTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void tetx01(){
        List<Book> all = bookService.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }
}
