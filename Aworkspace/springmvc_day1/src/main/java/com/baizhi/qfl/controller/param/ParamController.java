package com.baizhi.qfl.controller.param;

import com.baizhi.qfl.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/param1")
public class ParamController {
    @RequestMapping("/test1")///param1/test2?name="zs"&age=18&bir=1999-07-27
    public String test1(String name, Integer age,@DateTimeFormat(pattern = "yyyy-MM-dd") Date bir) {
        System.out.println(name+"-"+age+"-bir:"+bir);
        return "test";
    }
    @RequestMapping("/test2")// /param1/test2?name="zs"&age=18&bir=1999-07-27
    public String test2(User user) {
        System.out.println(user);
        return "index";
    }
    @RequestMapping("/test3")// /param1/test2?name="zs"&age=18&bir=1999-07-27&test=11
    public String test2(User user,Integer test) {
        System.out.println("姓名:："+user);
        System.out.println("test:"+test);
        return "index";
    }
}
