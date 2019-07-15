package com.tj.service;

import com.tj.category.HappysysCategory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: CloudProject
 * @Date: 2019/7/5 19:45
 * @Author: Mr.Deng
 * @Description:
 */

 //通过网关服务访问
@FeignClient(value = "HAPPY-CATEGORY")
public interface HappysysCategoryClientService {

 @RequestMapping(value = "/HappysysCategory/get/{id}",method = RequestMethod.GET)
 public HappysysCategory get(@PathVariable("id") long id);

 @RequestMapping(value = "/HappysysCategory/list",method = RequestMethod.GET)
 public List<HappysysCategory> list();

 @RequestMapping(value = "/HappysysCategory/add",method = RequestMethod.POST)
 public boolean add(HappysysCategory HappysysCategory);

}
