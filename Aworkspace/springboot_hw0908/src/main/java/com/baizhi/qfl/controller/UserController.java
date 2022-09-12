package com.baizhi.qfl.controller;

import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.service.UserService;
import com.baizhi.qfl.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("all")
    public CommonVO queryAll1() throws IOException {
        return userService.queryAll1();
    }
    @RequestMapping("one")
    public CommonVO queryOne(Integer id) throws IOException {
        System.out.println(id);
        return userService.queryById(id);
    }
    @RequestMapping("del")
    /*public CommonVO delete(Integer id){
        return userService.deleteById(id);
    }*/
    public CommonVO delete(String id){
        Integer id1=Integer.parseInt(id);
        return userService.deleteById(id1);
    }
    @RequestMapping("edit")
    public CommonVO update(@RequestBody User user){
        System.out.println(user);
        return userService.updateById(user);
    }
    @RequestMapping("add")
    public CommonVO add1(@RequestBody User user){
        System.out.println(user);
        return userService.add1(user);
    }
    /*@Autowired
    private UserService userService;
    @Autowired
    private HttpServletResponse response;
    @RequestMapping("showAll")
    public CommonVO queryAll1() throws IOException {
        return userService.queryAll1();
    }
    @RequestMapping("showOne")
    public CommonVO queryOne(Integer id) throws IOException {
        System.out.println(id);
        return userService.queryById(id);
    }
    @RequestMapping("delete")
    *//*public CommonVO delete(Integer id){
        return userService.deleteById(id);
    }*//*
    public CommonVO delete(String id){
        Integer id1=Integer.parseInt(id);
        return userService.deleteById(id1);
    }
    @RequestMapping("update")
    public CommonVO update(@RequestBody User user){
        System.out.println(user);
        return userService.updateById(user);
    }
    @RequestMapping("add")
    public CommonVO add1(@RequestBody User user){
        System.out.println(user);
        return userService.add1(user);
    }*/
    /*public CommonVO add1( User user){
        System.out.println(user);
        return userService.add1(user);
    }*/
}
