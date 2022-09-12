package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public CommonVO queryById(Integer id) {
        CommonVO commonVO = new CommonVO();
        User u =userDao.queryById(id);
        return commonVO.setStatus(true).setData(u);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAll() {
        //CommonVO commonVO = new CommonVO();
        List<User> list = userDao.queryAll();
        return list;
    }

    @Override
    public CommonVO add1(User user) {
        CommonVO commonVO = new CommonVO();
        String name=user.getName();
        User u= userDao.queryByName(name);
        if(u==null){
            //添加
            userDao.insert(user);
        }else {
            //返回错误信息
            //request.setAttribute("ErrorMess","该用户已存在");
            return commonVO.setMessage("该用户已存在");
        }
        return commonVO.setStatus(true);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommonVO queryAll1() {
        CommonVO commonVO = new CommonVO();
        return commonVO.setStatus(true).setData(userDao.queryAll());
    }

    @Override
    public  void add(User user) {
        //CommonVO commonVO = new CommonVO();
        String name=user.getName();
        User u= userDao.queryByName(name);
        if(u==null){
            //添加
            userDao.insert(user);
        }else {
            //返回错误信息
            request.setAttribute("ErrorMess","该用户已存在");
            //return commonVO.setMessage("该用户已存在");
        }
        //return commonVO.setStatus(true);
    }

    @Override
    public CommonVO deleteById(Integer id) {
        CommonVO commonVO = new CommonVO();
        System.out.println(id);
        userDao.deleteById(id);

        return commonVO.setStatus(true);
    }

    @Override
    public CommonVO updateById(User user) {
        CommonVO commonVO = new CommonVO();
        Integer id=user.getId();
        String name=user.getName();
        Integer age=user.getAge();
        Date bir=user.getBir();
        if(id==null||name==null||age == null||bir==null ){
            //返回错误信息
            return commonVO.setMessage("信息有空值，该用户更新失败");

        }else {
            //更新
            userDao.updateById(user);
        }
        return commonVO.setStatus(true);
    }
}
