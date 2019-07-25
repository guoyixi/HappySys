package com.tj.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.ProductMapper;
import com.tj.product.HappysysPoduct;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, HappysysPoduct> implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<HappysysPoduct> getByMap(Map<String,Object> conditons, Integer currentPage, Integer size){
        IPage page = new Page<>(currentPage,size);

        IPage<HappysysPoduct> resultPage = new Page<>();
        resultPage.setRecords(productMapper.getByMap(conditons,page));
        return resultPage;
    }




}
