package com.tj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;
import com.tj.product.HappysysProduct;
import com.tj.product.HappysysSection;

import java.util.List;
import java.util.Map;

public interface ProductService extends IService<HappysysProduct> {


    IPage<HappysysProduct> getByMap(Map<String,Object> conditons, Integer currentPage, Integer size);

    List<HappysysSection> getSection(Integer productId);
    List<HappysysFeature> getFeature(Integer productId);
    List<HappysysInsurance> getInsurance(Integer productId);

}
