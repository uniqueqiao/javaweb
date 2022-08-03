package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.ClazzDao;
import com.baizhi.qfl.dao.GroupDao;
import com.baizhi.qfl.entity.Clazz;
import com.baizhi.qfl.entity.Group;
import com.baizhi.qfl.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class GroupServiceImpl implements GroupService{

    @Override
    public List<Group> getAll() {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法获取省份数据
            GroupDao dao = session.getMapper(GroupDao.class);
            List<Group> list = dao.selectAll();
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
            GroupDao dao = session.getMapper(GroupDao.class);
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
    public void insert(Group group) {
        SqlSession session = null;
        try{
            session = DBUtil.openSession();
            // 调用dao的方法
            GroupDao dao = session.getMapper(GroupDao.class);
            // clazzdao根据id获取
            ClazzDao cdao = session.getMapper(ClazzDao.class);
            Clazz c=cdao.selectById(group.getClazz().getId());
            Group g=dao.selectByNameAndCName(group.getName(),c.getName());
            if (g == null) {
                group.setCreateDate(new Date());
                dao.insert(group);
            }else{
                throw new RuntimeException("该班级的小组已存在");
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
