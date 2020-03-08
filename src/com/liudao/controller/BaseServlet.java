package com.liudao.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/3 - 16:21
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        try {
            //获取action的鉴别字符,获取响应的业务,方法反射对象
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            //之后相应对象调用方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type","text-html;charset=utf-8");
    }

}
