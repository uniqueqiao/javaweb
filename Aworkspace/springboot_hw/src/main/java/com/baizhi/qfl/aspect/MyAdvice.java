package com.baizhi.qfl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    //1.通过方法级别切入点表达式实现所有的service方法执行前输出”业务方法将被执行”
    @Before("execution(* com.baizhi.qfl.service.*Impl.*(..))")
    public void before(JoinPoint a){
        System.out.println("业务方法将被执行");
    }
    //2.通过注解级别切入点表达式实现登录和注册两个方法正常执行后输出”登录或注册方法已被执行”
    @AfterReturning("@annotation(com.baizhi.qfl.annotation.MyAnno)")
    public void afterReturning(JoinPoint a) {
        System.out.println("登录或注册方法已被执行");
    }
    //异常通知方法
    //returning属性表示需要目标方法的返回值，这个返回值会被加到这个字符串代表的形参上
    @AfterThrowing(value = "execution(* com.baizhi.qfl.service.*Impl.*(..))", throwing = "ex")
    public void test3(JoinPoint joinPoint, Throwable ex){
        System.out.println("异常通知，异常信息为：" + ex.getMessage());
    }

}
