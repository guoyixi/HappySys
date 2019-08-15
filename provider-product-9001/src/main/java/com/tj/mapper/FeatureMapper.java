package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.product.HappysysFeature;

import java.util.List;

public interface FeatureMapper extends BaseMapper<HappysysFeature> {

    List<HappysysFeature> getAllFeature();

}
