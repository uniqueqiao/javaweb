package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Student;

import java.util.List;

public interface StudentDao {
    //1：增加
    public void insert(Student student);
    //2：删除
    public void deleteById(int id) ;
    //3：修改
    public void updateById(Student student);
    //4：查看所有
    public List<Student> queryAll();
    //5,6,7：根据姓名手机qq： 模糊
    public List<Student> selectByNameLike(String name);
    public List<Student> selectByTelLike(String tel);
    public List<Student> selectByQQLike(String qq);

}
