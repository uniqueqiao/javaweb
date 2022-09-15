package com.baizhi.qfl.hanlder;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    //可以书写多个方法来分别处理不同的异常，value值是个数组，里面是要处理的异常的类对象
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        request.setAttribute("errorMess",e.getMessage());
        return "error";
    }
    @ExceptionHandler({SQLException.class, IOException.class}) //处理Sql异常和IO异常（SqlException类和其子类）
    public String handlerSqlAndIOException(HttpServletRequest request, Exception ex){
        ex.printStackTrace();
        request.setAttribute("errorMess", "出错了！！！");
        return "error";
    }
}
