package com.baizhi.qfl.dao;

import com.baizhi.qfl.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //1：增加
    public void insert(Student student);
    //1.1 添加 student_tag
    public void insertStudentTag(@Param("sid") Integer sid,@Param("tid")Integer tid);
    //2：删除
    public void deleteById(int id) ;
    //2.1 添加 student_tag
    public void deleteStudentTag(Integer sid);
    //3：修改
    public void updateById(Student student);
    //4：查看所有
    public List<Student> queryAll();
    //4.2分页查询
    public List<Student> selectStudent(int begin);
    //4.3查有几行数据
    public int queryTotalRow();
    //5：根据姓名： 模糊
    public List<Student> selectByLike(@Param("begin") Integer begin,@Param("colName")String colName,@Param("colValue")String colValue);
    //5.1查有几行数据
    public int queryTotalRowNameLike(@Param("colName")String colName,@Param("colValue")String colValue);
    //6. 根据id 异步查
    public Student queryById(Integer id);
    //7. 查班级-小组的count
    public List<Student> selectByGroupId(@Param("gid")Integer gid );
    //8. 根据城市id查student
    public List<Student> selectByCityId(Integer cid );
    //9.根据班级id查Student
    public List<Student> selectByClazzId(Integer cid );
    //10. 根据tagID删除student_tag 表的内容
    public void deleteStudentATag(Integer tid);


}
