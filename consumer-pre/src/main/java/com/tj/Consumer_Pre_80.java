package com.tj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: happysys
 * @Date: 2019/7/11 11:52
 * @Author: Mr.Deng
 * @Description:
 */
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.tj.service"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Consumer_Pre_80 {

 public static void main(String[] args) {
  SpringApplication.run(Consumer_Pre_80.class,args);
 }

}
