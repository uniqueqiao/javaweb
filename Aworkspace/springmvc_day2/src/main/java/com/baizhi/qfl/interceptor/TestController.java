package com.baizhi.qfl.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/a")
    public String a(){
        System.out.println("/a---a");
        return "index";
    }
}
