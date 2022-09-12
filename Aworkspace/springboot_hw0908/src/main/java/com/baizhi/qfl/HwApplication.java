package com.baizhi.qfl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.qfl.dao")
public class HwApplication {
    public static void main(String[] args) {
        SpringApplication.run(HwApplication.class, args);
    }
}
