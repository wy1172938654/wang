package com.hbsi.wang.mapper;

import com.hbsi.wang.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 添加用户
     * */
    int insertUser(User user);
    /**
     * 查询用户是否存在
     * */
    User selectUsername(User user);
    /**
     * 登录
     * */
    User selectUserPass(@Param("user") User user);
}
