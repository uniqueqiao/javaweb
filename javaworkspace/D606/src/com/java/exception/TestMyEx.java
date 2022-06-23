package com.java.exception;

public class TestMyEx {
    public static void main(String[] args) {
        checkPassword("123");
        checkPassword("123456");
    }
    public static void checkPassword(String p){
        //密码必须6位，否则异常提示
        try {
            if (p.length()!=6) {
                throw new CheckPasswordException("密码不足6位");
            }else {
                System.out.println("验证成功......");
            }
        }catch (CheckPasswordException e) {
            System.out.println(e.getMessage());
        }

    }
}
//自定义异常类
class CheckPasswordException extends Exception{
//运行时异常

    public CheckPasswordException() {
    }

    public CheckPasswordException(String message) {
        super(message);
    }
}
