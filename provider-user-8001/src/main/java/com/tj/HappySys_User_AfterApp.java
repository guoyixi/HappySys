package com.tj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan({"com.tj.dao"})
@EnableTransactionManagement
public class HappySys_User_AfterApp {
    public static void main(String[] args) {
        SpringApplication.run(HappySys_User_AfterApp.class, args);
    }
}
