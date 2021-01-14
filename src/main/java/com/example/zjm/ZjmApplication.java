package com.example.zjm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zjm.dao")
public class ZjmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjmApplication.class, args);
    }

}
