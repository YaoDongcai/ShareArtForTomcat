package com.example.serviceImp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.TeacherBean;
import com.example.commons.RemoteHttpRequest;
import com.example.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodongcai on 2017/1/15.
 */
@Service
public class IndexServiceImp implements IndexService {
    private static final Logger logger = LoggerFactory.getLogger(IndexServiceImp.class);

    private ArrayList<TeacherBean> arrayList;
    @Override
    public List<TeacherBean> getTeachersList() {
        // 获取数据库里面的数字;
        String result = RemoteHttpRequest.httpGet("https://api.leancloud.cn/1.1/classes/Teacher");
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        logger.info("----jsonArray"+jsonArray);
//
        List<TeacherBean> arrayList = JSON.parseArray(jsonArray.toJSONString(),TeacherBean.class);
        logger.info("----arrayList");
        for(int i=0;i<arrayList.size();i++) {
            logger.info("----arrayList");
            logger.info(arrayList.get(i).toString());
        }
        //gson 转换为TeacherBean；
        return arrayList;
    }
}
