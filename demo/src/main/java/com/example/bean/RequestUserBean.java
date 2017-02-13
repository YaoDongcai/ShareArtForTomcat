package com.example.bean;

import org.springframework.stereotype.Component;

/**
 * Created by yaodongcai on 2017/1/7.
 */
@Component
public class RequestUserBean {
    /* 对象的id */
    private String objectId ;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
