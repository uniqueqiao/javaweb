package com.baizhi.qfl.controller.hw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("loginS")
public class LoginHwController {
    @RequestMapping
    public String login(HttpServletRequest request,HttpSession session,String username,String password){
        if("aaa".equals(username)&&"111111".equals(password)){
            session.setAttribute("username", username);
            System.out.println(username+"-"+password);
            return "redirect:/okhw.jsp";
        }else {
            request.setAttribute("errorMess", "登录失败");
            return "login";
        }
    }
}
