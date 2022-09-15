package com.baizhi.qfl.controller;

import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.service.UserService;
import com.baizhi.qfl.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpSession session;
    @RequestMapping("login")
    public String login(User user) {
        return  userService.login(user);
    }
    @RequestMapping("/")//删掉index.jsp ,这里/就变成了默认路径，
    public String home() {
        List<User> list = userService.queryAll();
        request.setAttribute("list", list);
        return "WEB-INF/home";//forward跳转
    }
    @RequestMapping("/logout")
    public String logout(){
        session.removeAttribute("username");
        return "redirect:/login.jsp";
    }
    @RequestMapping("/reg")
    public String reg(MultipartFile photo,User user ) throws IOException  {
        String fileName;
        if(photo == null || photo.getSize() == 0){
            //用户未上传文件或者上传的文件大小为0（大小为0的文件没有上传的意义）
            fileName = "default.jpg";
        }else{
            boolean isImage = photo.getContentType().startsWith("image/");
            if(!isImage) {
            request.setAttribute("errorMess", "上传的非图片");
            return "regist";
        }
            fileName = photo.getOriginalFilename();
        }
        String path=session.getServletContext().getRealPath("/statics/avatar");
        photo.transferTo(new File(path,fileName));
        user.setAvatar(fileName);
        return userService.regist(user);
    }
    @RequestMapping("registCheck")
    @ResponseBody
    public CommonVO registCheck(String username) throws IOException {
        System.out.println(userService.registCheck(username).getStatus());
        return userService.registCheck(username);
    }
    @RequestMapping("delete")
    public String delete(Integer id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
