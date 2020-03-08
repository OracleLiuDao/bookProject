package com.liudao.dao.impl;

import com.liudao.dao.UserDao;
import com.liudao.pojo.User;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/1 - 22:49
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int addUser(User user) {
        String sql = "insert into t_user(username,password,email) " +
                "values(?,?,?)";
            return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(sql,User.class,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(sql,User.class,username,password);
    }
}
