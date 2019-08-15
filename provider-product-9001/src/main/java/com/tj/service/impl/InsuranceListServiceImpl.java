package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.InsuranceListMapper;
import com.tj.product.HappysysInsuranceList;
import com.tj.service.InsuranceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class InsuranceListServiceImpl  extends ServiceImpl<InsuranceListMapper, HappysysInsuranceList> implements InsuranceListService {

    @Autowired
    private InsuranceListMapper insuranceListMapper;


}
