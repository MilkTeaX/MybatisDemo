import com.tzx.dao.ArticleDao;
import com.tzx.dao.UserDao;
import com.tzx.entity.Article;
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
    private ArticleDao articleDao;

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
        articleDao = session.getMapper(ArticleDao.class);
    }

    @AfterEach
    public void destroy() throws IOException {
        session.commit();
        // 释放对象
        session.close();
        inputStream.close();
    }

    @Test
    public void finAllArticles(){
        List<Article> articleList = articleDao.finAllArticles();
        for (Article article: articleList) {
            System.out.println(article);
        }
    }


    @Test
    public void findAllUser(){
        List<User> userList = userDao.findAllUser();
        for(User user : userList) {
            System.out.println("-----------------------");
            System.out.println(user);
            System.out.println(user.getArticles());
        }
    }



}
