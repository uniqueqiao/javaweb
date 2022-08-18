package com.baizhi.qfl.controller.hw;

import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.entity.User1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("list")
public class ListController {
    @RequestMapping
    public String test(HttpServletRequest request,String username, @DateTimeFormat(pattern = "yyyy-MM-dd") Date bir) {
        List<User1> list=new ArrayList<>();
        list.add(new User1("aaa",new Date()));
        list.add(new User1("bbb",new Date()));
        list.add(new User1("ccc",new Date()));
        request.setAttribute("list",list);
        return "showAll";
    }
}
