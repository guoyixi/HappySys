package com.tj.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @program: HappySys
 * @Date: 2019/8/2 16:25
 * @Author: Mr.Deng
 * @Description:
 */
/**
 * 配置druid过滤规则
 * @author young
 *
 */
@Configuration
public class DruidConfig {

 @ConfigurationProperties(prefix = "spring.datasource")
 @Bean
 public DataSource druid() {
  return new DruidDataSource();
 }


}
