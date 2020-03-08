package com.liudao.service.impl;

import com.liudao.dao.BookDao;
import com.liudao.dao.impl.BookDaoImpl;
import com.liudao.pojo.Book;
import com.liudao.pojo.Page;
import com.liudao.service.BookService;

import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/4 - 9:08
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleBookById(Integer id) {
            bookDao.deleBookById(id);
    }

    @Override
    public void updateBook(Book book) {
            bookDao.updateBook(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findOneById(Integer id) {
        return bookDao.findOneById(id);
    }

   /* @Override
    //给page的五个属性赋值
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page =new Page<Book>();
        //设置当前页马
        page.setPageNo(pageNo);
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求书的总记录数 去数据库查count(*)
        Integer pageTotalConunt=bookDao.queryForPageTotalCount();
        //设置书的总记录数
        page.setPageTotalCount(pageTotalConunt);
        //求总页码  = 总记录数除以每页显示的数量 总数9显示4 2余1 所以当余数大于1 要加一页 页就是3页
        Integer pageTotal = pageTotalConunt/pageSize;
        if (pageTotalConunt%pageSize>0){
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //当前页数据的数据索引
        int begin = (page.getPageNo()-1)*pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }*/
   @Override
   public Page<Book> page(int pageNo, int pageSize) {
       Page<Book> page = new Page<Book>();

       // 设置每页显示的数量
       page.setPageSize(pageSize);
       // 求总记录数
       Integer pageTotalCount = bookDao.queryForPageTotalCount();
       // 设置总记录数
       page.setPageTotalCount(pageTotalCount);
       // 求总页码
       Integer pageTotal = pageTotalCount / pageSize;
       if (pageTotalCount % pageSize > 0) {
           pageTotal+=1;
       }
       // 设置总页码
       page.setPageTotal(pageTotal);
           page.setPageNo(pageNo);
       // 求当前页数据的开始索引
       int begin = (page.getPageNo() - 1) * pageSize;
       // 求当前页数据
       List<Book> items = bookDao.queryForPageItems(begin,pageSize);
       // 设置当前页数据
       page.setItems(items);

       return page;
   }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        // 设置当前页数据
        page.setItems(items);


        return page;
    }


}
