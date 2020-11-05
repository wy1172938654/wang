package com.hbsi.wang.service;

import com.hbsi.wang.bean.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     * 添加用户
     * */
    String insertUser(User user, HttpSession session, String code);
    /**
     *用户登录
     * */
    String selectUserPass(User user,HttpSession session);
}
