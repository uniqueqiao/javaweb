package com.baizhi.qfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController1 {
    @RequestMapping
    public String hello() {//访问/a/b
        System.out.println("/user test");
        return "index";//页面逻辑名 是 controller forward跳转。jsp
    }
    @RequestMapping("/a/b") //访问路径/user/a/b
    public String test1(){
        System.out.println("/user/a/b test");
        return "redirect:/index.jsp";//redirect不会通过视图解析器 是 controller redirect重定向跳转。jsp
    }
}
