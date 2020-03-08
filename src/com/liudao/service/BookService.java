package com.liudao.service;

import com.liudao.pojo.Book;
import com.liudao.pojo.Page;

import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/4 - 9:00
 */
public interface BookService {
    public void addBook(Book book);
    public void deleBookById(Integer id);
    public void updateBook(Book book);
    public List<Book> findAll();
    public Book findOneById(Integer id);


    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
