package com.tj.controller;

import com.tj.category.HappysysCategory;
import com.tj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

 @Autowired
 private CategoryService categoryService;

 @RequestMapping("/HappysysCategory/list")
 public List<HappysysCategory> list(){
  return categoryService.list();
 }
	
}
