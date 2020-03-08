package com.liudao.dao.impl;

import com.liudao.dao.BookDao;
import com.liudao.pojo.Book;
import com.liudao.pojo.Page;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/3 - 22:13
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,price,sales,author,stock,ima_path)" +
                "values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getSales(),book.getAuthor(),book.getStock(),book.getImaPath());
    }

    @Override
    public int deleBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`ima_path`=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImaPath(),book.getId());
        }

    @Override
    public List<Book> findAll() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `ima_path` imaPath from t_book";
        return queryForList(sql,Book.class);
    }

    @Override
    public Book findOneById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `ima_path` imaPath from t_book where id = ?";
        return queryForOne(sql,Book.class,id);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql ="select count(*) from t_book";
         Number count= (Number) queryForSingValue(sql);
         return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `ima_path` imaPath from t_book limit ?,?";
        return queryForList(sql,Book.class,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql ="select count(*) from t_book where price between ? and ?";
        Number count= (Number) queryForSingValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `ima_path` imaPath " +
                "from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(sql,Book.class,min,max,begin,pageSize);
    }


}

