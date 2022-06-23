package com.java.map;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {
        //key 学号 value 姓名
        HashMap<String,String> map=new HashMap<>();
        map.put("wq001", "aa");
        map.put("wq002", "bb");
        map.put("wq003", "cc");
       /* //替换
        String oldValue=map.put("wq002","dd");
        //集合长度
        System.out.println(map.size());//长度
        System.out.println("被替换value:"+oldValue);
        System.out.println(map.get("wq002"));//获取value
        System.out.println(map.containsKey("wq002"));//T
        System.out.println(map.containsValue("dd"));//T
        map.remove("wq002");//删除键值对
        System.out.println(map.containsKey("wq002"));//F
        System.out.println(map.containsValue("dd"));//F
        */
        System.out.println("键遍历");
        //获取所有键
        Set<String> keys = map.keySet();
        //遍历Set获取键
        for (String key : keys) {
            //key获取value
            String value=map.get(key);
            System.out.println(key+"-"+value);
        }
        System.out.println("键值对遍历");
        //获取所有键值对Entry<K,V> | map.entrySet();
        Set<Map.Entry<String,String>> kvs=map.entrySet();
        //遍历Set集合,获取每个键值对
        for (Map.Entry<String,String> kv:kvs) {
            //获取键值对的键
            String  key=kv.getKey();
            //获取键值对的值
            String  value=kv.getValue();
            System.out.println("key:"+key+",value:"+value);
        }
    }
}
