package com.hisoft.easybuy.dao;

import com.hisoft.easybuy.javabeen.entity.User;

import java.sql.SQLException;

/**
 * @Created by IntelliJ IDEA.
 * @Author: XiaoMing
 * @Date: 2021/7/2
 * @Time: 15:07
 * Come on, boy
 **/
public interface UserDao {


    /**
     * 根据用户名和密码查找用户
     * @param loginName
     * @param password
     * @return
     */
     public User findUser(String loginName, String password) throws SQLException;
}
