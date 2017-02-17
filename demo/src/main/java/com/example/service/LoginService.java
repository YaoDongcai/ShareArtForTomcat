package com.example.service;

import com.example.bean.User;
import org.springframework.stereotype.Service;

/**
 * Created by yaodongcai on 2017/1/7.
 */
@Service
public interface LoginService {
    public void getName(User user);
    public boolean isUser(User user) ;

}
