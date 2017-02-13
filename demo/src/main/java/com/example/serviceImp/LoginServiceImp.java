package com.example.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.example.bean.RequestUserBean;
import com.example.bean.TeacherBean;
import com.example.bean.User;
import com.example.commons.RemoteHttpRequest;
import com.example.service.LoginService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    ArrayList<TeacherBean> arrayList ;

    public LoginServiceImp() {
        // id key master key
        logger.info("------loginServiceImp constrctor");
//        AVOSCloud.initialize("MPPgPonVVgoN8d3YDQaJ7TWN-gzGzoHsz","WHTzQQg2fLDectWzUhDMBk22WHTzQQg2fLDectWzUhDMBk22","iSJT46oOi1alPPvwXaa8Dky9");
    }

    @Override
    public void getName(User user) {
        logger.info("-----------getName");

        String result = RemoteHttpRequest.httpGet("https://api.leancloud.cn/1.1/classes/test/57712af0165abd00548803ef");
        JSONObject jsonObject = JSONObject.parseObject(result);
        logger.info(result);
        // 开始解析jsonArray数据;
//        if(jsonObject.get("status").toString().equals("ok")) {
//
            JSONArray jsonArray = jsonObject.getJSONArray("results");
        logger.info("----jsonArray"+jsonArray);
//
           List<TeacherBean> arrayList = JSON.parseArray(jsonArray.toJSONString(),TeacherBean.class);
        logger.info("----arrayList");
        for(int i=0;i<arrayList.size();i++) {
            logger.info("----arrayList");
            logger.info(arrayList.get(i).toString());
        }
//        }
    }
}
