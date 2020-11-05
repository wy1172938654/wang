package com.hbsi.wang.service.Impl;

import com.hbsi.wang.bean.User;
import com.hbsi.wang.config.Md5Utils;
import com.hbsi.wang.mapper.UserMapper;
import com.hbsi.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;
    /**
     * 添加用户
     * */
    @Override
    public String insertUser(User user, HttpSession session, String code) {
        String password= Md5Utils.code(user.getPassword());
        String sess= (String) session.getAttribute("code");
        user.setPassword(password);
        user.setId(UUID.randomUUID().toString());
        user.setState("000");
        User user1 = userMapper.selectUsername(user);
        if (user1==null) {
            if (sess.equals(code)) {
                userMapper.insertUser(user);
                return "redirect:/user/toLog";
            } else {
                return "redirect:/user/reg";
            }
        }else {
            return "redirect:/user/reg";
        }
    }

    @Override
    public String selectUserPass(User user, HttpSession session) {
        String password=Md5Utils.code(user.getPassword());
        user.setPassword(password);
        Map<String,Object> map=new HashMap<>();
        if (userMapper.selectUsername(user)==null){
            System.out.println("用户名不存在先注册");
            map.put("msg","用户名不存在");
            return "redirect:/user/reg";
        }
        User user1 = userMapper.selectUserPass(user);
        if (user.getPassword().equals(user1.getPassword())){
            session.setAttribute("username",user.getUsername());
            return "redirect:/emp/getAll/1/2";
        }else {
            map.put("msg","密码不正确");
            return "redirect:/user/toLog";
        }
    }

}
