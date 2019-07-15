package com.tj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.tj.mapper")
@EnableEurekaClient
@SpringBootApplication
public class ProviderCategory_9001_App {
	public static void main(String[] args)	{
		SpringApplication.run(ProviderCategory_9001_App.class, args);
	}
}
