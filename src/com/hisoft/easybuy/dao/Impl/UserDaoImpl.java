package com.hisoft.easybuy.dao.Impl;

import com.hisoft.easybuy.dao.UserDao;
import com.hisoft.easybuy.javabeen.entity.User;
import com.hisoft.easybuy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Created by IntelliJ IDEA.
 * @Author: XiaoMing
 * @Date: 2021/7/2
 * @Time: 15:10
 * Come on, boy
 **/
public class UserDaoImpl implements UserDao {
    private Connection conn;

    public UserDaoImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public User findUser(String Name, String pwd) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            pstmt = conn.prepareStatement("select id from easybuy_user where loginName = ? and password = ?");
            pstmt.setString(1,Name);
            pstmt.setString(2,pwd);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                user = new User(id, Name, pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.closeAll(rs,pstmt,null);
        }
        return user;
    }
}
