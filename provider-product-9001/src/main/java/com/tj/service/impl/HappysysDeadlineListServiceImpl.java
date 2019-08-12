package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.HappysysDeadlineListMapper;
import com.tj.product.HappysysDeadlineList;
import com.tj.service.HappysysDeadlineListService;
import com.tj.service.HappysysSectionListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class HappysysDeadlineListServiceImpl extends ServiceImpl<HappysysDeadlineListMapper,HappysysDeadlineList> implements HappysysDeadlineListService {
}
