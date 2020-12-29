package com.tzx.dao.impl;

import com.mysql.cj.xdevapi.SessionFactory;
import com.tzx.dao.UserDao;
import com.tzx.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @program: MybatisDemo
 * @description: mybatis使用代理的方式可以自动扩展，不需要手动写实现类
 *                  但也可以手动写实现类，这里是一个例子
 * @author: lemonSoul
 * @create: 2020-12-20 16:38
 **/
public class UserDaoImpl implements UserDao {

    private final SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<User> findAllUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.tzx.dao.UserDao.findAllUser");
        sqlSession.close();
        return userList;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(User user) {

    }

    public User findOneUser(Integer userId) {
        return null;
    }

    public List<User> finOneUserByLike(String username) {
        return null;
    }
}
