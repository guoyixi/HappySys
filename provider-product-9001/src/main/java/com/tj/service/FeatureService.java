package com.tj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;

import java.util.List;

public interface FeatureService extends IService<HappysysFeature> {
    public List<HappysysFeature> getFeature(Integer productId);
    public List<HappysysInsurance> getInsurance(Integer productId);
}
