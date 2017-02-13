package com.example.controllers;

import com.example.bean.TeacherBean;
import com.example.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodongcai on 2017/1/15.
 */
@Controller
@RequestMapping(value = "/index",name = "首页模块")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private List<TeacherBean> arrayList; // 教员数组;

    @Autowired
    private IndexService indexService;
    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        //渲染首页的Teacher值
        arrayList = indexService.getTeachersList();
        // 填充数据;
        map.addAttribute("arrayList",arrayList);

        return "index/index";
    }
}
