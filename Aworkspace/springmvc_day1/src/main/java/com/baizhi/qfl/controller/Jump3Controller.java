package com.baizhi.qfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/jump3")
public class Jump3Controller {
    @RequestMapping("/hello")
    public String test2(HttpServletRequest request, HttpSession session) {
        System.out.println("jump3-hello");
        return "redirect:/index.jsp";
    }
}
