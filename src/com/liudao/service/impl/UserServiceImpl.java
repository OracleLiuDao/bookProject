package com.liudao.service.impl;

import com.liudao.dao.UserDao;
import com.liudao.dao.impl.UserDaoImpl;
import com.liudao.pojo.User;
import com.liudao.service.UserService;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/2 - 10:02
 */
public class UserServiceImpl implements UserService {
   private UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        userDao.addUser(user);
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        if (user == null){
            return false;
        }
       return true;
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());

    }
}
