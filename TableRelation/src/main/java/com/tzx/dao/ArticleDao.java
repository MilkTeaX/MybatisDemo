package com.tzx.dao;

import com.tzx.entity.Article;

import java.util.List;

/**
 * @program: ArticleDao
 * @description:
 * @author: lemonSoul
 * @create: 2021/1/2 17:28
 **/
public interface ArticleDao {

    /**
     * 查询所有文章
     * @return
     */
    List<Article> finAllArticles();
}
