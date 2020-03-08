package com.liudao.test;

import com.liudao.dao.UserDao;
import com.liudao.dao.impl.UserDaoImpl;
import com.liudao.pojo.User;
import org.junit.Test;



/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/2 - 9:43
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void addUser(){
        userDao.addUser(new User(null,"六道","123","123@qq.com"));

    }
    @Test
    public void queryUserByUsername(){

        User username = userDao.queryUserByUsername("修道12");
        if(username ==null){
            System.out.println("用户名可以使用");
        }else {
            System.out.println("用户名已被注册");
        }

    }
    @Test
    public void queryUserByUsernameAndPassword(){
        User user = userDao.queryUserByUsernameAndPassword("修道2", "12345671");
        if (user==null){
            System.out.println("用户名或密码错误");
        }else {
            System.out.println("登录成功");
        }
    }

}