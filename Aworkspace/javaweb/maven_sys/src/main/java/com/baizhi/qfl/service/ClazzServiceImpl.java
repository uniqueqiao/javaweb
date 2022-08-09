package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.ClazzDao;
import com.baizhi.qfl.dao.StudentDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Student;
import com.baizhi.qfl.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClazzServiceImpl implements ClazzService{
    @Override
    public Clazz selectById(Integer id) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            ClazzDao dao = session.getMapper(ClazzDao.class);
            Clazz c = dao.selectById(id);
            // session.commit();  只有业务里涉及到 增删改
            return c;
        }catch(Exception e){
            e.printStackTrace();
            // session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

    @Override
    public Clazz selectByName(String name) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            ClazzDao dao = session.getMapper(ClazzDao.class);
            Clazz c = dao.selectByName(name);
            // session.commit();  只有业务里涉及到 增删改
            return c;
        }catch(Exception e){
            e.printStackTrace();
            // session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

    @Override
    public List<Clazz> getAll() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            ClazzDao dao = session.getMapper(ClazzDao.class);
            List<Clazz> list = dao.selectAll();
            // session.commit();  只有业务里涉及到 增删改
            return list;
        }catch(Exception e){
            e.printStackTrace();
            // session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

    @Override
    public List<Clazz> getAllClazz() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            ClazzDao dao = session.getMapper(ClazzDao.class);
            List<Clazz> list = dao.queryAll();
            // session.commit();  只有业务里涉及到 增删改
            return list;
        }catch(Exception e){
            e.printStackTrace();
            // session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

    @Override
    public void delete(Integer id) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            ClazzDao dao = session.getMapper(ClazzDao.class);
            StudentDao sdao=session.getMapper(StudentDao.class);
            List<Student> list=sdao.selectByClazzId(id);
            if (list.size() != 0) {
                throw new RuntimeException("该班级有关联用户，不能删除");
            }else{

                dao.delete(id);
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
    public void insert(Clazz clazz) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            ClazzDao dao = session.getMapper(ClazzDao.class);
            Clazz c=dao.selectByName(clazz.getName());
            if (c == null) {
                dao.insert(clazz);
            }else{
                throw new RuntimeException("该班级已存在");
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
}
