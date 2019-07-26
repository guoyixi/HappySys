package com.tj.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.CategoryMapper;
import com.tj.product.HappysysCategory;
import com.tj.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, HappysysCategory> implements CategoryService {


 @Override
 public List<HappysysCategory> findCategoryAndChild(Integer parentId) {
  System.out.println("-----------------------------------------------");

  List<HappysysCategory> happysysCategories = this.list(new QueryWrapper<HappysysCategory>().eq("category_parent_id", parentId));

  List<HappysysCategory> child = findChild(happysysCategories, parentId);

  //  System.out.println("*************************************************size:" + child.size());
//
//  for (HappysysCategory category : child) {
//   System.out.println("------------:" + category.getCategoryName());
//
//   if (category.getHappysysCategories() != null) {
//
//    List<HappysysCategory> happysysCategories1 = category.getHappysysCategories();
//
//    for (HappysysCategory happysysCategory : happysysCategories1) {
//     System.out.println("------------------------:" + happysysCategory.getCategoryName());
//
//
//     if (happysysCategory.getHappysysCategories() != null) {
//      List<HappysysCategory> happysysCategories2 = happysysCategory.getHappysysCategories();
//
//      for (HappysysCategory happysys : happysysCategories2) {
//       System.out.println("------------------------------------::" + happysys.getCategoryName());
//
//      }
//     }
//    }
//   }
//  }

  return child;
 }


 public List<HappysysCategory> findChild(List<HappysysCategory> happysysCategoryList, Integer parentId) {

  List<HappysysCategory> list = new ArrayList<>();

  //没有子类则退出
  if (happysysCategoryList != null) {

   //parent_id为n的所有子类
   for (HappysysCategory happysysCategory : happysysCategoryList) {

    //对子即类数据进行封装
    HappysysCategory category = new HappysysCategory();
    category.setCategoryId(happysysCategory.getCategoryId());
    category.setCategoryName(happysysCategory.getCategoryName());
    category.setCategoryType(happysysCategory.getCategoryType());
    category.setCategoryParentId(happysysCategory.getCategoryParentId());

    List<HappysysCategory> happysysCategories = this.list(new QueryWrapper<HappysysCategory>().eq("category_parent_id", happysysCategory.getCategoryId()));

    if (happysysCategories.size()>0) {
     category.setHappysysCategories(this.findChild(happysysCategories, happysysCategory.getCategoryId()));
    }

    list.add(category);

   }

   return list;
  }
  return list;
 }



}
