package com.example.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.User;
import com.example.commons.RemoteHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaodongcai on 2017/2/16.
 */
@Controller
@RequestMapping(value = "/user",name = "个人中心模块")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/index")
    public String index(ModelMap map) {

    // JSONObject jsonObject = JSONObject.parseObject(result);
    // JSONArray jsonArray = jsonObject.getJSONArray("results");
    // logger.info("----jsonArray"+jsonArray);
        return "user/index";
    }
    // 消息列表
    @RequestMapping(value = "/message")
    public String message(ModelMap map) {
        return "user/message";
    }
    // 建立简历
    @RequestMapping(value = "/resume")
    public String resume(ModelMap map) {
        return "user/resume";
    }
    // 更新消息
    @RequestMapping(value = "/follow")
    public String follow(ModelMap map) {
        return "user/follow";
    }

}
