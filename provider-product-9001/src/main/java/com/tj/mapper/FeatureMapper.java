package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;

import java.util.List;

public interface FeatureMapper extends BaseMapper<HappysysFeature>{

    List<HappysysFeature> getFeature(Integer productId);
    List<HappysysInsurance> getInsurance(Integer productId);
}
