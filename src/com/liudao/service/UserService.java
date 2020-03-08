package com.liudao.service;

import com.liudao.pojo.User;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/2 - 9:33
 */
public interface UserService {
    //注册一个用户
    public void register(User user);
    //查询用户名是否可用
    public boolean existsUsername(String username);
    //登录
    public User login(User user);

}
