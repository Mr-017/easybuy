package com.hisoft.easybuy.service.Impl;

import com.hisoft.easybuy.dao.UserDao;
import com.hisoft.easybuy.dao.UserDaoImpl;
import com.hisoft.easybuy.javabeen.entity.User;
import com.hisoft.easybuy.service.UserService;
import com.hisoft.easybuy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Created by IntelliJ IDEA.
 * @Author: XiaoMing
 * @Date: 2021/7/2
 * @Time: 15:28
 * Come on, boy
 **/
public class UserServiceImpl implements UserService {
    private Connection conn;

    @Override
    public User login(String loginName, String password) {
        conn = JdbcUtil.getConnection();
        UserDao userDao = new UserDaoImpl(conn);
        User user = null;
        try {
            user = userDao.findUser(loginName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(null, null, conn);
        }
        return user;
    }
}
