package com.baizhi.qfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/jump1")
public class Jump1Controller {
    @RequestMapping("/test1")
    public String test1(HttpServletRequest request) {
        request.setAttribute("name", "张三");
        return "test";//redirect不会通过视图解析器 是 controller redirect重定向跳转。jsp
    }

    @RequestMapping("/test2")
    public String test2(HttpServletRequest request, HttpSession session) {
        request.setAttribute("name", "张三");
        session.setAttribute("age", "18");
        return "redirect:/test.jsp";//redirect不会通过视图解析器 是 controller redirect重定向跳转。jsp
    }
}
