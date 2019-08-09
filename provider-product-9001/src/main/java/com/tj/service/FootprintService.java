package com.tj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysFootprint;
import com.tj.product.HappysysProduct;

import java.util.List;

public interface FootprintService extends IService<HappysysFootprint> {

    List<HappysysProduct> getFootprintProductByUserId(Integer userId);


}
