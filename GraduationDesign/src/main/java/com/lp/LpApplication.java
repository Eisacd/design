package com.lp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lp.mapper")
public class LpApplication {
    public static void main(String[] args){
        SpringApplication.run(LpApplication.class , args);
    }
}
