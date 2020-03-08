package com.liudao.dao;

import com.liudao.pojo.User;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/1 - 22:37
 */
public interface UserDao {

    //添加一名用户
     public int addUser(User user);
    //根据用户名查询用户信息
    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username,String password);



}
