package com.liudao.test;

import com.liudao.dao.BookDao;
import com.liudao.dao.impl.BookDaoImpl;
import com.liudao.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/4 - 8:55
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void test1(){
        bookDao.addBook(new Book(null,"liudao",new BigDecimal(999),10,"不知道",100,null));
    }
}
