package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.HappysysFeatureListMapper;
import com.tj.product.HappysysFeatureList;
import com.tj.service.HappysysFeatureListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class HappysysFeatureListServiceImpl extends ServiceImpl<HappysysFeatureListMapper,HappysysFeatureList> implements HappysysFeatureListService {
}
