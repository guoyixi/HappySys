package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.ProductMapper;
import com.tj.product.HappysysPoduct;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, HappysysPoduct> implements ProductService{

    @Autowired
    private ProductMapper productMapper;






}
