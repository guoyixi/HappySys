package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.DeadlineMapper;
import com.tj.product.HappysysDeadline;
import com.tj.service.DeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeadlineServiceImpl extends ServiceImpl<DeadlineMapper, HappysysDeadline> implements DeadlineService {

    @Autowired
    private DeadlineMapper deadlineMapper;


}
