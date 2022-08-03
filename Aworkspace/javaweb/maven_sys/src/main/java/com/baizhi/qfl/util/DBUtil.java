package com.baizhi.qfl.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class DBUtil {
    private static SqlSessionFactory factory=null;
    static{
        try {
            //1.SqlSessionFactoryBuilder 盖房子的建筑工人
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            //2. IO流读取mybatis.xml文件中的配置信息 启动mybatis框架需要的数据---建筑材料
            InputStream is= Resources.getResourceAsStream("mybatis.xml");//从src下开始写
            //3.SqlSessionFactory---盖工厂
            factory = builder.build(is);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static ThreadLocal<SqlSession> tol=new ThreadLocal<SqlSession>() ;
    public static SqlSession openSession(){
        SqlSession session = tol.get();
        //4. SqlSession ----生产产品
        if(session == null){
            session = factory.openSession();
            tol.set(session);
        }
        return session;
    }
    //释放资源
    public static void close(){
        SqlSession session = openSession();
        if(session != null){
            try {
                session.close();
                tol.remove();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    // StudenDao dao==session.getMapper(StudentDao.class);//接口的类对象
    public static Object getDao(Class a){
        SqlSession session = openSession();
        return session.getMapper(a);

    }
    //session.commit();
    public static void commit() {
        SqlSession session=openSession();
        session.commit();
        close();//直接在commit提交。testDao完全不出现close
    }
    //可以不暴露底层的任何技术
}
