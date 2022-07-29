package com.baizhi.qfl.test;

import com.alibaba.fastjson.JSON;
import com.baizhi.qfl.entity.Student;
import org.junit.Test;

import java.util.*;

public class TestJasonn {
    @Test
    public void testJson(){
        Student s=new Student(1,"zs",18,new Date());
        String jsOBJ = JSON.toJSONString(s);
        System.out.println(jsOBJ);
        String jsOBJ2 = JSON.toJSONStringWithDateFormat(s,"yyyy-MM-dd");//月的MM必须大写
        System.out.println(jsOBJ2);
        Student s1=new Student(2,"zs",18,new Date());
        Student s2=new Student(3,"zs",18,new Date());
        List<Student> list=new ArrayList<Student>();
        list.add(s);
        list.add(s1);
        list.add(s2);
        String jsOBJ3 = JSON.toJSONString(list);
        String jsOBJ4 = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");//月的MM必须大写
        System.out.println(jsOBJ3);
        System.out.println(jsOBJ4);


        //Map集合
        Map<String,Student> map = new HashMap<>();
        map.put("aaa", s);
        map.put("bbb", s1);
        map.put("ccc", s2);
        String jsOBJ5 = JSON.toJSONString(map);
        String jsOBJ6 = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd");//月的MM必须大写
        System.out.println(jsOBJ5);//key 看做对象  value 看做对象的属性值
        System.out.println(jsOBJ6);
    }
}
