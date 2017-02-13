package com.example.bean;

import org.springframework.stereotype.Component;

/**
 * Created by dcyao on 2016/11/3.
 */
// 定义User 实体类
@Component
public class User {
    private String name; // 用户名
    private String pwd; //用户密码
    private String region; //预留一个字段作为未来的移动端或者pc端的类型

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
