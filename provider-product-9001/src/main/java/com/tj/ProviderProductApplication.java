package com.tj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching      //启动redis
@SpringBootApplication
@MapperScan("com.tj.mapper")
@EnableEurekaClient
@EnableTransactionManagement
public class ProviderProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderProductApplication.class,args);
    }


}
