package com.tj.product.controller;

import com.tj.product.HappysysCategory;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: happysys
 * @Date: 2019/7/11 11:04
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class CategoryController {

 @Autowired
 private HappysysProductClientService happysysProductClientService;

 @RequestMapping("category/list")
 @ResponseBody
 public List<HappysysCategory> category(){
  return this.happysysProductClientService.list();
 }

}
