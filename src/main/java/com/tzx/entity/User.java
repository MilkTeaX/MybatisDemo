package com.tzx.entity;

/**
 * @program: MybatisDemo
 * @description: user
 * @author: lemonSoul
 * @create: 2020-12-19 23:12
 **/
public class User {

    private Integer userid;
    private String username;
    private String userpassword;
    private String useremail;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}

