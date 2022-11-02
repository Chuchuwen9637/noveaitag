package com.nanjie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nanjie.*")
public class novelaibtApplication {
    public static void main(String[] args) {
        SpringApplication.run(novelaibtApplication.class,args);
    }
}
