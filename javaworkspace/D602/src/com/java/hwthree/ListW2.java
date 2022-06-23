package com.java.hwthree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
public class ListW2 {
    public static void main(String[] args) {
        /*在main函数中定义一个List集合，存储以下字符串内容：
        bj2001-已毕业
        tj2002-未毕业
        bj2003-已毕业
        bj2004-未毕业
        tj2010-未毕业
        将以上内容存储在List集合中，*/
        ArrayList<String> list = new ArrayList<String>();
        list.add("bj2001-已毕业");
        list.add("tj2002-未毕业");
        list.add("bj2003-已毕业");
        list.add("bj2004-未毕业");
        list.add("tj2010-未毕业");
        //然后遍历将信息转存到Map集合中：//以班级号作为key，是否毕业作为value，
        HashMap<String,String> map=new HashMap<String, String>();
        for (String str: list) {
            String[] s=str.split("-");
            map.put(s[0], s[1]);
        }
        System.out.println(map);
        //打印输出所有未毕业的班级号。
        System.out.println("----打印输出所有未毕业的班级号----");
        //获取所有键
        Set<String> keys = map.keySet();
        //遍历Set获取键
        for (String key : keys) {
            //key获取value
            String value=map.get(key);
            if(value.equals("未毕业"))
            System.out.println(key);
        }
    }
}
