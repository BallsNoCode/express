package com.kkb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author APPDE
 */
@SpringBootApplication
@MapperScan("com.kkb.mapper")
public class UserRun {
    public static void main(String[] args) {
        SpringApplication.run(UserRun.class, args);
    }
}
