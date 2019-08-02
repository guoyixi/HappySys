package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.InsuranceMapper;
import com.tj.product.HappysysInsurance;
import com.tj.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class InsuranceServiceImpl extends ServiceImpl<InsuranceMapper, HappysysInsurance> implements InsuranceService {

    @Autowired
    private InsuranceMapper insuranceMapper;


    @Override
    public List<HappysysInsurance> getInsuranceByOrderId(Integer orderId){

        return insuranceMapper.getInsuranceByOrderId(orderId);
    }

}
