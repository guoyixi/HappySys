package com.tj.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.ProductMapper;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;
import com.tj.product.HappysysProduct;
import com.tj.product.HappysysSection;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, HappysysProduct> implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<HappysysProduct> getByMap(Map<String,Object> conditons, Integer currentPage, Integer size){
        IPage page = new Page<>(currentPage,size);

        IPage<HappysysProduct> resultPage = new Page<>();
        resultPage.setRecords(productMapper.getByMap(conditons,page));
        return resultPage;
    }

    @Override
    public List<HappysysSection> getSection(Integer productId) {
        return productMapper.getSection(productId);
    }
    @Override
    public List<HappysysFeature> getFeature(Integer productId){
        return productMapper.getFeature(productId);
    }
    @Override
    public List<HappysysInsurance> getInsurance(Integer productId){
        return productMapper.getInsurance(productId);
    }




}
