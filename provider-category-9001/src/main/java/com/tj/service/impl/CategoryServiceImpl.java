package com.tj.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.category.HappysysCategory;
import com.tj.mapper.CategoryMapper;
import com.tj.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,HappysysCategory> implements CategoryService {



}
