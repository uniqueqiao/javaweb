package com.java.yuekao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class XuanW9 {
    public static void main(String[] args) {
        int[] a={1,3,4,2,6,3,4,2,3};
        System.out.println(FirstAppearTwice(a));
    }
    public static Integer FirstAppearTwice(int[] a){
        HashMap<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else {
                map.put(a[i],1);
            }
        }
        int flag=0;
        Set<Integer> keys = map.keySet();
        for (Integer key:keys) {
            Integer value = map.get(key);
            if(value==2){
                flag++;
                return key;
            }
        }
        if (flag ==0) {
            return null;
        }
        return -1;
    }
}
