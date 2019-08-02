package com.tj.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @program: HappySys
 * @Date: 2019/8/2 16:33
 * @Author: Mr.Deng
 * @Description:
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
 initParams={
  @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
 })
public class DruidStatFilter extends WebStatFilter {
}
