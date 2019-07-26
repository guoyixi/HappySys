package com.tj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tj.product.HappysysCategory;
import com.tj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

 @Autowired
 private CategoryService categoryService;

 @RequestMapping( value = "/HappysysCategory/list",method = RequestMethod.GET)
 @ResponseBody
 public List<HappysysCategory> list() {

  System.out.println("----------------List------------------");

  return categoryService.findCategoryAndChild(0);

 }












 @RequestMapping(value = "/HappysysCategory/get/{id}",method = RequestMethod.GET)
 public List<HappysysCategory> recursionObject(@PathVariable("id") Integer id) {

  System.out.println("-----------------Get------------------:"+id);

   //根据parent_ID查询出子集
   return categoryService.list(new QueryWrapper<HappysysCategory>().eq("category_parent_id",id));
 }

 @RequestMapping(value = "/HappysysCategory/add",method = RequestMethod.POST)
 public boolean add(@RequestBody HappysysCategory happysysCategory){

  System.out.println("参数："+happysysCategory);

  return categoryService.save(happysysCategory);
 }

}

/*
 */
