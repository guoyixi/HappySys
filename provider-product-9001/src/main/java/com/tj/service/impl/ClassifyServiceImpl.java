package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.ClassifyMapper;
import com.tj.product.HappysysClassify;
import com.tj.service.ClassifyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper,HappysysClassify> implements ClassifyService {
}
