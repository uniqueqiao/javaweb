package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.UserDao;
import com.baizhi.qfl.entity.User;
import com.baizhi.qfl.util.DBUtil;
import com.baizhi.qfl.util.Salt;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService{
    @Override
    public User queryByName(String name) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            UserDao dao = session.getMapper(UserDao.class);
            User u=dao.selectByUserName(name);
            return u;
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

    @Override
    public void regist(User user) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            UserDao dao = session.getMapper(UserDao.class);
            User u=dao.selectByUserName(user.getUsername());
            if (u != null) {
                throw new RuntimeException("用户已存在");
            }else {
                String salt= Salt.getSalt();
                String pw= DigestUtils.md5Hex(user.getPassword()+salt);
                user.setPassword(pw);
                user.setSalt(salt);
                dao.insert(user);
                System.out.println(user);
            }
            session.commit();  //只有业务里涉及到 增删改
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

    @Override
    public User Login(User user) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            UserDao dao = session.getMapper(UserDao.class);
            User u=dao.selectByUserName(user.getUsername());
            System.out.println(u);
            if (u == null) {
                //System.out.println("用户不存在");
                throw new RuntimeException("用户不存在");
            }else{
                String salt= u.getSalt();
                String pwMd5= DigestUtils.md5Hex(user.getPassword()+salt);
                if(pwMd5.equals(u.getPassword())==false){
                    //System.out.println("密码错误");
                    throw new RuntimeException("密码错误");
                }
            }
            return u;
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

}
