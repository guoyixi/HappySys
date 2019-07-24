package com.tj.service;

import com.tj.product.HappysysCategory;
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


}
