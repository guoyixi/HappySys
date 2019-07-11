package com.tj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient          //启动后会自动注册进eureka服务中
@EnableCircuitBreaker								//对hystrix熔断机制的支持
public class ProviderCategory_8001_App {
	public static void main(String[] args)	{
		SpringApplication.run(ProviderCategory_8001_App.class, args);
	}
}
