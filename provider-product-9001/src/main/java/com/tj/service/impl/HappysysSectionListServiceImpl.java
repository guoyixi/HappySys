package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.HappysysSectionListMapper;
import com.tj.product.HappysysSectionList;
import com.tj.service.HappysysSectionListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class HappysysSectionListServiceImpl extends ServiceImpl<HappysysSectionListMapper,HappysysSectionList> implements HappysysSectionListService {
}
