package com.tzx.dao;

import com.tzx.entity.User;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param user
     */
    void deleteUser(User user);

    /**
     * 查询单个用户
     * @param userId
     * @return
     */
    User findOneUser(Integer userId);

    /**
     * 根据名字模糊查询
     * @param username
     * @return
     */
    List<User> finOneUserByLike(String username);
}
