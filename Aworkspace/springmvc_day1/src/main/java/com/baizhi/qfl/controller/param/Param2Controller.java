package com.baizhi.qfl.controller.param;

import com.baizhi.qfl.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/param2")
public class Param2Controller {
    @RequestMapping("/test1")///param2/test1?hobby=test1&hobby=test2
    public String test1(String[] hobby) {
        for (String s : hobby) {
            System.out.println(s);
        }
        return "index";
    }
}