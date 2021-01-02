package com.tzx.dao;

import com.tzx.entity.User;

import java.util.List;

/**
 * @program: MybatisDemo
 * @description: userDao
 * @author: lemonSoul
 * @create: 2020-12-19 23:22
 **/
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    //@Select("select * from user")
    List<User> findAllUser();

}
