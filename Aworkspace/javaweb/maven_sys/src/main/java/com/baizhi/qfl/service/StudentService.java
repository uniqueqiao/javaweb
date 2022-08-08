package com.baizhi.qfl.service;

import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    // 1. 查所有分页
    public List<Student> getStudent(int pn);
    //2. 获取总页数
    public int getTotalPage();
    //3. 删除byid
    public void deleteById(Integer id);
    //4. 添加 id
    public void insert(Student stu,List<Integer> tids);
    // 5. 模糊查所有
    public List<Student> getStudentLike(String colName,String text);
    // 6. 异步根据id查
    public Student getStudentById(Integer id);
    // 7.更新
    public void updateStudentById(Student stu,List<Integer> tids);

}
