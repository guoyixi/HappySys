package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.SectionMapper;
import com.tj.product.HappysysSection;
import com.tj.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SectionServiceImpl extends ServiceImpl<SectionMapper, HappysysSection> implements SectionService {


    @Autowired
    private SectionMapper secionMapper;


}
