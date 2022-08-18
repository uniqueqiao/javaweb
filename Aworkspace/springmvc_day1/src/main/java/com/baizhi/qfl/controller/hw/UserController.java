package com.baizhi.qfl.controller.hw;

import com.baizhi.qfl.entity.User1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
@RequestMapping("user")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("info")
    public String test(String username, @DateTimeFormat(pattern = "yyyy-MM-dd") Date bir) {
        logger.debug("username:{},bir:{}",username,bir);
        return "index";
    }
    @RequestMapping("info2")
    public String test(User1 u) {
        logger.debug("user:name={},bir={}",u.getUsername(),u.getBir());
        return "index";
    }
}
