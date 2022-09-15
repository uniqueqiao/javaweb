package com.baizhi.qfl.service;

import com.baizhi.qfl.annotation.MyAnno;
import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.util.SaltUtil;
import com.baizhi.qfl.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryByName(String username) {
        return userDao.queryByName(username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    @MyAnno
    @Transactional(propagation = Propagation.SUPPORTS)
    public String login(User user) {
        if(user.getUsername().trim().equals("")){
            request.setAttribute("errorMess","用户名不能为空");
            return "login";
        }
        if(user.getPassword().equals("")){
            request.setAttribute("errorMess","密码不能为空");
            return "login";
        }
        User u=userDao.queryByName(user.getUsername());
        if (u == null) {
            request.setAttribute("errorMess","用户不存在");
            return "login";
        }else {
            String salt= u.getSalt();
            String pwMd5= SaltUtil.getPassword(user.getPassword(),salt);
            if(pwMd5.equals(u.getPassword())==false){
                //System.out.println("密码错误");
                request.setAttribute("errorMess","密码错误");
                return "login";
            }else{
                session.setAttribute("user", u);
                return "redirect:/";
            }
        }
    }

    @Override
    @MyAnno
    @Transactional(propagation = Propagation.SUPPORTS)
    public String regist(User user) {
        if(user.getUsername().trim().equals("")){
            request.setAttribute("errorMess","用户名不能为空");
            return "regist";
        }
        if(user.getPassword().equals("")){
            request.setAttribute("errorMess","密码不能为空");
            return "regist";
        }
        User u=userDao.queryByName(user.getUsername().trim());
        if (u != null) {
            request.setAttribute("errorMess","该用户名已存在");
        }else {
            String salt= SaltUtil.getSalt();
            String pw=SaltUtil.getPassword(user.getPassword(),salt);
            /*String salt= Salt.getSalt();
            String pw= DigestUtils.md5Hex(user.getPassword()+salt);*/
            user.setPassword(pw) ;
            user.setSalt(salt);
            user.setCreateTime(new Date());
            userDao.add(user);
            System.out.println(user);
            return "login";
        }
        return "error";
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommonVO registCheck(String username) {
        CommonVO commonVO = new CommonVO();
        username=username.trim();
        if(username.equals("")){
            return commonVO.setMessage("必须填写用户名");
        }
        User u=userDao.queryByName(username.trim());
        if(u!=null){
            System.out.println(commonVO.getStatus());
            return commonVO.setMessage("用户名已存在，不允许注册");
        }
        return commonVO.setStatus(true);
    }

    @Override
    public String deleteById(Integer id) {
        User u =(User) session.getAttribute("user");
        if(u.getId().equals(id)){
            request.setAttribute("errorMess", "不能删除当前用户");
            return "error";
        }
        String path = request.getSession().getServletContext().getRealPath("/statics/avatar");
        //获取文件原始名称
        String fileName=userDao.queryById(id).getAvatar();
        if(!fileName.equals("default.jpg")){
            //当头像文件不是系统默认时才删除图片
            new File(path,fileName).delete();
        }
        userDao.deleteById(id);
        return "/";
    }
}
