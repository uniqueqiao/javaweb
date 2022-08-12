package com.baizhi.qfl.service;

import com.baizhi.qfl.dao.UserDao;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TestServiceImpl {
    private String name;
    private Integer age;
    private Date bir;
    private UserDao userDao;
    private String[] strs;
    private UserDao[] uds;
    private Map<String,String> map;
    private Map<String,UserDao> udmap;
    private Properties p;
    private List<UserDao> udlist;

    public void setUdlist(List<UserDao> udlist) {
        this.udlist = udlist;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public void setUdmap(Map<String, UserDao> udmap) {
        this.udmap = udmap;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setUds(UserDao[] uds) {
        this.uds = uds;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    @Override
    public String toString() {
        return "TestServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                ", userDao=" + userDao +
                '}';
    }
    public void test(){
        //userDao.save("zs1");
        //Arrays.toString(strs);
        //System.out.println(Arrays.toString(uds));
        /*for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("------------");
        }*/
        for (Map.Entry<String, UserDao> entry : udmap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("------------");
        }
        /*for (String stringPropertyName : p.stringPropertyNames()) {
            System.out.println(stringPropertyName);
            System.out.println(p.getProperty(stringPropertyName));
            System.out.println("--------");
        }*/
        /*for (UserDao dao : udlist) {
            System.out.println(dao);
        }*/
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
