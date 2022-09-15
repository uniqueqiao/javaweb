package com.baizhi.qfl.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

public class SaltUtil {
    public static String getSalt(){
        return getSalt(20);
    }

    public static String getSalt(int size){
        char[] pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0;i < size;i ++){
            sb.append(pool[random.nextInt(pool.length)]);
        }
        return sb.toString();
    }

    public static String getPassword(String pass, String salt){
        pass = pass + salt;
        String md5 = DigestUtils.md5DigestAsHex(pass.getBytes());
        return md5;
    }
}
