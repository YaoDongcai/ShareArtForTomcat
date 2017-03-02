package com.example.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.bean.RequestUserBean;
import com.example.bean.TeacherBean;
import com.example.bean.User;
import com.example.commons.RemoteHttpRequest;
import com.example.service.LoginService;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodongcai on 2017/1/7.
 */
@Service
public class LoginServiceImp implements LoginService{
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
    @Autowired
    private RequestUserBean userBean;
    @Autowired
    private User user;
//    ArrayList<TeacherBean> arrayList ;

    public LoginServiceImp() {
        // id key master key
        logger.info("------loginServiceImp constrctor");
//        AVOSCloud.initialize("MPPgPonVVgoN8d3YDQaJ7TWN-gzGzoHsz","WHTzQQg2fLDectWzUhDMBk22WHTzQQg2fLDectWzUhDMBk22","iSJT46oOi1alPPvwXaa8Dky9");
    }

    @Override
    public void getName(User user) {
        logger.info("-----------getName");
    }

    @Override
    public boolean isUser(User user) {
        logger.info("----user index");
//        测试账号和密码
//        User user = new User("Tom","123456789");
        String strjosn = JSON.toJSONString(user);

        String result = RemoteHttpRequest.getHttpPostResponse("https://api.leancloud.cn/1.1/login",strjosn);
        JSONObject jsonObject = JSONObject.parseObject(result);
        logger.info("result"+result);

        if(!jsonObject.get("sessionToken").toString().equals("")) {
            return true;
        }
        return false;
    }
}
