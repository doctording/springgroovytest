package com.example.demorepo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author mubi
 * @Date 2021/2/12 14:04
 */
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.example.demorepo.repository")
public class DemoRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRepoApplication.class, args);
    }

}
