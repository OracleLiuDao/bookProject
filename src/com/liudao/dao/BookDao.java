package com.liudao.dao;

import com.liudao.pojo.Book;
import com.liudao.pojo.Page;

import java.awt.*;
import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/3 - 22:04
 */
public interface BookDao {

    public int addBook(Book book);
    public int deleBookById(Integer id);
    public int updateBook(Book book);
    public List<Book> findAll();
    public Book findOneById(Integer id);


    Integer queryForPageTotalCount();


    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
