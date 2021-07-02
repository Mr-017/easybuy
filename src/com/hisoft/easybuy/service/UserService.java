package com.hisoft.easybuy.service;

import com.hisoft.easybuy.javabeen.entity.User;

/**
 * @Created by IntelliJ IDEA.
 * @Author: XiaoMing
 * @Date: 2021/7/2
 * @Time: 15:26
 * Come on, boy
 **/
public interface UserService {


    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    public User login(String loginName, String password);
}
