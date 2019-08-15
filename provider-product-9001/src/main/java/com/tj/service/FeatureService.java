package com.tj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysFeature;

import java.util.List;

public interface FeatureService extends IService<HappysysFeature> {

    List<HappysysFeature> getAllFeature();


}
