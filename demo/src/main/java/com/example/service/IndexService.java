package com.example.service;

import com.example.bean.TeacherBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodongcai on 2017/1/15.
 */
@Service
public interface IndexService {
    // 获取教员列表
    public List<TeacherBean> getTeachersList() ;
}
