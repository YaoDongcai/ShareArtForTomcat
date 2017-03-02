package com.example.controllers;

import com.example.bean.User;

import com.example.service.LoginService;
import com.example.serviceImp.LoginServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yaodongcai on 2017/1/7.
 */
@Controller
@RequestMapping(value = "/login",name = "登陆模块")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginServiceImp loginService;




    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        LOGGER.info("--------------index page");
        map.addAttribute("user", new User());
        map.addAttribute("title","登陆界面");
        return "login-in";
    }
    @RequestMapping(value = "/success")
    public String success(@ModelAttribute(value = "user") User user,HttpServletRequest httpServletRequest) {
        LOGGER.info("access success page");
        LOGGER.info("-----------user:"+user.toString());
        if(loginService.isUser(user)) {
            // 设置session ;
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("user",user.getUsername());
            return "redirect:/user/index";
        }else{
            return "redirect:/login/";
        }
    }

}
