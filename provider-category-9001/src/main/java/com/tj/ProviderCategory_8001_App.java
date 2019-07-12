package com.tj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient          //启动后会自动注册进eureka服务中
@MapperScan("com.tj.mapper")
public class ProviderCategory_8001_App {
	public static void main(String[] args)	{
		SpringApplication.run(ProviderCategory_8001_App.class, args);
	}
}
