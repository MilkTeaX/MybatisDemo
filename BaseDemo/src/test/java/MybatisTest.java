import com.tzx.dao.UserDao;
import com.tzx.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: MybatisDemo
 * @description:
 * @author: lemonSoul
 * @create: 2020-12-19 23:25
 **/
public class MybatisTest {

    private InputStream inputStream;
    private SqlSession session;
    private UserDao userDao;

    @BeforeEach
    public void init() throws IOException {
        // 读取配置文件
        inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        // 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =
                new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory =
                sqlSessionFactoryBuilder.build(inputStream);
        // 使用工厂生产SqlSession对象
        session = sqlSessionFactory.openSession();
        // 使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @AfterEach
    public void destroy() throws IOException {
        session.commit();
        // 释放对象
        session.close();
        inputStream.close();
    }


    @Test
    public void queryUser() {

        //使用代理对象执行方法
        List<User> userList = userDao.findAllUser();
        for (User user: userList) {
            System.out.println(user);
        }
        /*
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> userList = userDao.findAllUser();
        for (User user: userList) {
            System.out.println(user);
        }*/
    }

    @Test
    public void saveUser(){
        User user = new User();
        //user.setUserid(4);
        user.setUserName("test");
        user.setUserPassword("789");
        user.setUserEmail("zhongx.tang@sunyard.com");
        userDao.saveUser(user);
        System.out.println(user.getUserId());
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setUserId(3);
        user.setUserName("TestUser");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser(){
        User user = new User();
        user.setUserId(17);
        userDao.deleteUser(user);
    }

    @Test
    public void findOneUser(){
        System.out.println(userDao.findOneUser(2));
    }

    @Test
    public void findOneUserByLike(){
        User users = new User();
        users.setUserName("%es%");
        List<User> userList = userDao.finOneUserByLike(users.getUserName());
        for (User user: userList) {
            System.out.println(user);
        }
    }

    @Test
    public void findOneUserByWhere(){
        User user = new User();
        user.setUserName("%test%");
        user.setUserEmail("%@%");
        List<User> userList = userDao.findOneUserByWhere(user);
        for (User users: userList) {
            System.out.println(users);
        }
    }

    @Test
    public void finUserByIn(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<User> listUser = userDao.finUserByIn(list);
        for (User user:listUser) {
            System.out.println(user);
        }
    }

}
