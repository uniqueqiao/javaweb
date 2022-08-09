package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.CityDao;
import com.baizhi.qfl.dao.StudentDao;
import com.baizhi.qfl.dao.TagDao;
import com.baizhi.qfl.entity.City;
import com.baizhi.qfl.entity.Tag;
import com.baizhi.qfl.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class TagServiceImpl implements TagService{
    @Override
    public List<Tag> queryAllStuTag() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            TagDao dao = session.getMapper(TagDao.class);
            List<Tag> list = dao.queryAllStuTag();
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
    public List<Tag> queryAllClazzTag() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            TagDao dao = session.getMapper(TagDao.class);
            List<Tag> list = dao.queryAllClazzTag();
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
    public List<Tag> getAll() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            TagDao dao = session.getMapper(TagDao.class);
            List<Tag> list = dao.selectAll();
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
            TagDao dao = session.getMapper(TagDao.class);
            StudentDao sdao=session.getMapper(StudentDao.class);
            sdao.deleteStudentATag(id);
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
    public void insert(Tag tag) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            TagDao dao = session.getMapper(TagDao.class);
            Tag t=dao.selectByNameAndType(tag.getName(), tag.getType());
            if (t == null) {
                tag.setCreateDate(new Date());
                dao.insert(tag);
            }else {
                throw new RuntimeException("该标签已存在");
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
