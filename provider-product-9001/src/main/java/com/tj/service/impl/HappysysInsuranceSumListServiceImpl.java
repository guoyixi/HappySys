package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.HappysysInsuranceSumListMapper;
import com.tj.product.HappysysInsuranceSumList;
import com.tj.service.HappysysInsuranceSumListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class HappysysInsuranceSumListServiceImpl extends ServiceImpl<HappysysInsuranceSumListMapper,HappysysInsuranceSumList> implements HappysysInsuranceSumListService {
}
