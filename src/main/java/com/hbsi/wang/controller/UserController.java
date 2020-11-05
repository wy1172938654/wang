package com.hbsi.wang.controller;

import com.hbsi.wang.bean.User;
import com.hbsi.wang.service.UserService;
import com.hbsi.wang.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    // 到登录页面去
    @RequestMapping("/toLog")
    public String test(){
        return "ems/login";
    }
    //登录
    @RequestMapping("ckLogin")
    public String ckLogin(User user,HttpSession session){
        return userService.selectUserPass(user,session);
    }

    //到注册页面
    @RequestMapping("/reg")
    public String toReg(){
        return "ems/regist";
    }
    @RequestMapping("/regSave")
    public String regSave(User user, HttpSession session, String code){
        return userService.insertUser(user,session,code);
    }
    //生成验证码
    @RequestMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //1,生成随机验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //2,吧生成的验证码转换成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        // 3,把生成验证码存入session
        session.setAttribute("code",securityCode);
        //4,通过流的方式响应图片
        ServletOutputStream outputStream = response.getOutputStream();
        // 5,通过imageIo 把第二部生成的验证码图片以png的方式响应给outputStream
        ImageIO.write(image,"png",outputStream);
    }
}
