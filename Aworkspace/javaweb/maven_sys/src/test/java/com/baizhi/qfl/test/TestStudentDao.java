package com.baizhi.qfl.test;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.StudentDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.entity.Student;
import com.baizhi.qfl.util.DBUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestStudentDao {
    @Test
    public void insert(){
        StudentDao dao = (StudentDao) DBUtil.getDao(StudentDao.class);
        Student s=new Student(null,"111",11,"111111","11111",new Date(),"1111","1111",null,new Clazz(10,null,null,null),new Group(4,null,null,null),new City(4,null),null);
        dao.insert(s);
        System.out.println(s.getId());
        DBUtil.commit();
    }
    @Test
    public void queryAllRow(){
        StudentDao dao = (StudentDao) DBUtil.getDao(StudentDao.class);
        int row=dao.queryTotalRow();
        System.out.println(row);
        DBUtil.commit();
    }
    @Test
    public void selectStudent(){
        StudentDao dao = (StudentDao) DBUtil.getDao(StudentDao.class);
        List<Student> list=dao.selectStudent(0);
        for (Student student : list) {
            System.out.println(student);
        }
        DBUtil.commit();
    }
    @Test
    public void delete(){
        StudentDao dao = (StudentDao) DBUtil.getDao(StudentDao.class);
        dao.deleteById(20);
        DBUtil.commit();
    }
    @Test
    public void queryByName(){
        StudentDao dao = (StudentDao) DBUtil.getDao(StudentDao.class);
        List<Student> list = dao.selectByLike("name", "%yan%");
        for (Student student : list) {
            System.out.println(student);
        }
        DBUtil.commit();
    }
    @Test
    public void queryNameRow(){
        StudentDao dao = (StudentDao) DBUtil.getDao(StudentDao.class);
        int row=dao.queryTotalRowNameLike("%ee%");
        System.out.println(row);
        DBUtil.commit();
    }
    @Test
    public void queryId(){
        StudentDao dao = (StudentDao) DBUtil.getDao(StudentDao.class);
        Student s=dao.queryById(22);
        System.out.println(s);
        DBUtil.commit();
    }
}
