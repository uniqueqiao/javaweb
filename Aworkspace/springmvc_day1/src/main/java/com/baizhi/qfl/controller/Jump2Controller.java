package com.baizhi.qfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/jump2")
public class Jump2Controller {
    @RequestMapping("/test1")
    public String test1(HttpServletRequest request, HttpSession session) {
        System.out.println("jump2-test1");
        return "forward:/jump2/test2";
    }
    @RequestMapping("/test2")
    public String test2(HttpServletRequest request, HttpSession session) {
        System.out.println("jump2-test2");
        return "index";
    }
    @RequestMapping("/test3")
    public String test3(HttpServletRequest request, HttpSession session) {
        System.out.println("jump2-test2");
        return "redirect:/jump3/hello";
    }
}
