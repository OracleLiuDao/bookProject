package com.liudao.controller;

import com.liudao.pojo.User;
import com.liudao.service.UserService;
import com.liudao.service.impl.UserServiceImpl;
import com.liudao.utils.WebUtils;
import com.sun.org.apache.regexp.internal.RE;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/3 - 14:45
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void loginout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath());
    }

        //登录servlet
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //判断用户名字和密码是否正确
        User loginUser = userService.login(new User(null, username, password, null));
        if(loginUser == null){

            System.out.println(username+"错误");
            //把错误信息和回显的表单项信息,保存在request域中
            req.setAttribute("msg","用户名或密码错误");
            //回显的信息
            req.setAttribute("username",username);
            //登录失败 跳回登录页
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);

        }else {
            req.getSession().setAttribute("user",loginUser);
            //登录成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }


    }
   //注册servlet
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token =(String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");



        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


/*        Map<String, String[]> map = req.getParameterMap();
        for(Map.Entry<String, String[]> entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+ Arrays.asList(entry.getValue()));
        }*/

        User user = WebUtils.copyParamByBean(new User(),req.getParameterMap());



        //检查验证码
        if(token!=null&&token.equalsIgnoreCase(code)){
            //验证码正确,检查用户名是否可用
            boolean b = userService.existsUsername(username);
            if(b){
                System.out.println("用户名["+username+"]已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.setAttribute("msg","用户名["+username+"]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.register(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }


        }else {
            //不正确返回注册页
            System.out.println("验证码错误"+code);
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }

}
