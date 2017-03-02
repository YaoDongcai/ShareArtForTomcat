package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yaodongcai on 2017/3/2.
 */

@Controller
@RequestMapping(value = "/sign",name = "注册模块")
public class SignController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignController.class);

    @RequestMapping(value = "/")
    public String sign(ModelMap map) {
        map.addAttribute("title","注册界面");
        return "sign-in";
    }
}
