package com.baizhi.qfl.util;

import java.util.Random;

public class Salt {
    public static void main(String[] args) {

    }
    public static String getSalt(){
        String[] str={"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                "o","p","q","r","s","t","u","v","w","x","y","z",
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                "O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "0","1","2","3","4","5","6","7","8","9"};//62
        String salt="";
        Random r=new Random();
        for(int i=0;i<6;i++){
            int index=r.nextInt(62);
            salt+=str[index];
        }
        return salt;
    }
}
