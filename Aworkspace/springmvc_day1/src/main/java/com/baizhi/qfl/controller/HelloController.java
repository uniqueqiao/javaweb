package com.baizhi.qfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class HelloController {
    @RequestMapping("/b")
    public String hello() {//访问/a/b
        System.out.println("hello test");
        return "index";//页面逻辑名 是 controller forward跳转。jsp
    }
    @RequestMapping("/c") //访问路径/a/c
    public String test1(){
        System.out.println("hello test");
        return "redirect:/index.jsp";//redirect不会通过视图解析器 是 controller redirect重定向跳转。jsp
    }
}
