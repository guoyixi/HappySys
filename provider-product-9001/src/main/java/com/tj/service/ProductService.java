package com.tj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysPoduct;

import java.util.Map;

public interface ProductService extends IService<HappysysPoduct> {


    IPage<HappysysPoduct> getByMap(Map<String,Object> conditons, Integer currentPage, Integer size);


}
