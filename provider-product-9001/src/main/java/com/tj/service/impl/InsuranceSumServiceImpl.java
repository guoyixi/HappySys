package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.InsuranceSumMapper;
import com.tj.product.HappysysInsuranceSum;
import com.tj.service.InsuranceSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class InsuranceSumServiceImpl extends ServiceImpl<InsuranceSumMapper, HappysysInsuranceSum> implements InsuranceSumService {

    @Autowired
    private InsuranceSumMapper insuranceSumMapper;

}
