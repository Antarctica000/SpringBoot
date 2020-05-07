package com.example.guavacache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.example.guavacache.mapper")
public class GuavacacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuavacacheApplication.class, args);
    }

}
