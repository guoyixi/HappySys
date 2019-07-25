package com.tj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysProduct;

import java.util.Map;

public interface ProductService extends IService<HappysysProduct> {


    IPage<HappysysProduct> getByMap(Map<String,Object> conditons, Integer currentPage, Integer size);


}
