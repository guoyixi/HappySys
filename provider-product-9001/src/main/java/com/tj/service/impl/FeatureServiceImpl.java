package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.FeatureMapper;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;
import com.tj.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FeatureServiceImpl extends ServiceImpl<FeatureMapper,HappysysFeature> implements FeatureService {
    @Autowired
    FeatureMapper featureMapper;


    public List<HappysysFeature> getFeature(Integer productId){
        return featureMapper.getFeature(productId);
    }
    public List<HappysysInsurance> getInsurance(Integer productId){
        return featureMapper.getInsurance(productId);
    }
}
