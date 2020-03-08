package com.liudao.controller;

import com.liudao.pojo.Book;
import com.liudao.pojo.Page;
import com.liudao.service.BookService;
import com.liudao.service.impl.BookServiceImpl;
import com.liudao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/4 - 9:10
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
   /* //处理分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要从客户端接收两个参数,一个是pageNo当前页和pageSize显示数量
        //获取当前页码设置为第1页
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        //获取当前页显示数量 设置为4
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //Page对象
        Page<Book> page  = bookService.page(pageNo,pageSize);
        //保存Page对象到request域中
        req.setAttribute("page",page);
        //请求转发到book管理的页面中
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
        //这里注意的分页功能调用,是在你点击图书管理的时候就调用了pageServlet,而以前的只是调用了查询全部数据的list
    }*/


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数,分装到javabean
        Book book = WebUtils.copyParamByBean(new Book(), req.getParameterMap());
        bookService.addBook(book);
      //  req.getRequestDispatcher("").forward(req,resp);  表单重复提交
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //类型转换
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleBookById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamByBean(new Book(),req.getParameterMap());
//        2、调用BookService.updateBook( book );修改图书
        bookService.updateBook(book);
//        3、重定向回图书列表管理页面
//        地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    protected void getbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.findOneById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
