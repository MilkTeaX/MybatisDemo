package com.tzx.entity;

import java.util.Date;

/**
 * @program: Article
 * @description:
 * @author: lemonSoul
 * @create: 2021/1/2 17:22
 **/
public class Article {

    private Integer articleId;
    private String articleName;
    private Date articleCreateTime;
    private Integer userId;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleCreateTime=" + articleCreateTime +
                ", userId=" + userId +
                '}';
    }
}
