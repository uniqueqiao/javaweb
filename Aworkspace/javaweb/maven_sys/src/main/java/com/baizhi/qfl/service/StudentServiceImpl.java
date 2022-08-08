package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.GroupDao;
import com.baizhi.qfl.dao.StudentDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.entity.Student;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.util.DBUtil;
import com.baizhi.qfl.util.DateUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    @Override
    public void updateStudentById(Student stu,List<Integer> tids) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            StudentDao dao = session.getMapper(StudentDao.class);
            int id=stu.getId();
            //Student stu=dao.queryById(id);
            //删除 student_tag 原有的
            dao.deleteStudentTag(id);
            //添加修改后的ids
            List<Tag> tags = stu.getTags();
            for(Integer tid:tids){
                Tag tag = new Tag();
                tag.setId(tid);
                tags.add(tag);
            }
            //根据group的id 获取到 clazz的id
            GroupDao gdao = (GroupDao) DBUtil.getDao(GroupDao.class);
            Group g=gdao.selectById(stu.getGroup().getId());
            stu.setClazz(g.getClazz());
            dao.updateById(stu);
            //修改关系表student_tag
            for(Integer tid:tids){
                dao.insertStudentTag(stu.getId(),tid);
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
    public Student getStudentById(Integer id) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            StudentDao dao = session.getMapper(StudentDao.class);
            Student s = dao.queryById(id);
            // session.commit();  只有业务里涉及到 增删改
            return s;
        }catch(Exception e){
            e.printStackTrace();
            // session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }
    }

    @Override
    public List<Student> getStudentLike(String colName,String text ) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            StudentDao dao = session.getMapper(StudentDao.class);
            /*int begin=(pn-1)*4;
            List<Student> list = dao.selectStudent(begin);*/
            String key="%"+text+"%";
            List<Student> list = dao.selectByLike(colName,key );
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
    public void insert(Student stu,List<Integer> tids) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            StudentDao dao = session.getMapper(StudentDao.class);
            //自动生成年龄生肖星座
            stu.setAge(DateUtil.getAge(stu.getBir()));
            stu.setStarts(DateUtil.getConstellation(stu.getBir()));
            stu.setAttr(DateUtil.getYear(stu.getBir()));
            //添加 ids
            List<Tag> tags = stu.getTags();
            for(Integer tid:tids){
                Tag tag = new Tag();
                tag.setId(tid);
                tags.add(tag);
            }
            //根据group的id 获取到 clazz的id
            GroupDao gdao = (GroupDao) DBUtil.getDao(GroupDao.class);
            Group g=gdao.selectById(stu.getGroup().getId());
            stu.setClazz(g.getClazz());
            dao.insert(stu);
            //修改关系表student_tag
            for(Integer tid:tids){
               dao.insertStudentTag(stu.getId(),tid);
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
    public void deleteById(Integer id) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            StudentDao dao = session.getMapper(StudentDao.class);
            //修改对应关系表student_tag
            dao.deleteStudentTag(id);
            dao.deleteById(id);
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
    public List<Student> getStudent(int pn) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            StudentDao dao = session.getMapper(StudentDao.class);
            int begin=(pn-1)*4;
            List<Student> list = dao.selectStudent(begin);
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
    public int getTotalPage() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            StudentDao dao = session.getMapper(StudentDao.class);
            //计算起始行数
            int total=dao.queryTotalRow();
            int totalPage=total/4;
            if (total%4!=0) {
                totalPage+=1;
            }
            return totalPage;
            // session.commit();  只有业务里涉及到 增删改

        }catch(Exception e){
            e.printStackTrace();
            // session.rollback();
            throw new RuntimeException(e.getMessage());
        }finally{
            DBUtil.close();
        }

    }
/* @Override
    public void delete(Integer id) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            CityDao dao = session.getMapper(CityDao.class);
            dao.delete(id);
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
    }*/
}
