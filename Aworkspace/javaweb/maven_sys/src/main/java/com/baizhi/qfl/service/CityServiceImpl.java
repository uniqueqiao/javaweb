package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.StudentDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Student;
import com.baizhi.qfl.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CityServiceImpl implements CityService{
    @Override
    public List<City> getAllCity() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            CityDao dao = session.getMapper(CityDao.class);
            List<City> list = dao.selectAll();
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
    public List<City> getAll() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            CityDao dao = session.getMapper(CityDao.class);
            List<City> list = dao.selectAll();
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
            CityDao dao = session.getMapper(CityDao.class);
            StudentDao sdao=session.getMapper(StudentDao.class);
            List<Student> list=sdao.selectByCityId(id);
            if (list.size() != 0) {
                 throw new RuntimeException("该城市有关联用户，不能删除");
            }else {
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
    public void insert(City city) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            CityDao dao = session.getMapper(CityDao.class);
            City c=dao.selectByName(city.getName());
            if (c == null) {
                dao.insert(city);
            }else{
                throw new RuntimeException("该城市已存在");
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
