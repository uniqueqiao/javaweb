package com.baizhi.qfl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping
    public String login(HttpServletRequest request, String username, String password) {
        logger.debug("用户名:{},密码:{}",username,password);
        if("aaa".equals(username)&&"111111".equals(password)){
            return "redirect:/ok.jsp";
        }else{
            request.setAttribute("errorMess","登录失败");
            return "login";
        }

    }
}
