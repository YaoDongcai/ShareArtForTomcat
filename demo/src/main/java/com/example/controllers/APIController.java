package com.example.controllers;

import com.example.bean.User;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by yaodongcai on 2017/2/16.
 */
@RestController
@RequestMapping(value = "/v1",name = "API调用接口，为了移动端做的接口服务")
public class APIController {
    @Autowired
    private LoginService loginService;
    // 获取数据库验证的对象;
    @PostMapping(value ="user")
    public ResponseEntity isUser(@RequestBody User user){

        HashMap result =new HashMap<>();

        if(loginService.isUser(user)) {
            result.put("message","true");
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        // 返回错误
        result.put("messsage","false");
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
