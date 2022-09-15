package com.baizhi.qfl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //能作用在方法上
@Retention(RetentionPolicy.RUNTIME) //运行时注解
public @interface MyAnno {
}
