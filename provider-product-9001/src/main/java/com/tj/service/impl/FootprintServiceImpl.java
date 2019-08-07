package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.FootprintMapper;
import com.tj.product.HappysysFootprint;
import com.tj.product.HappysysProduct;
import com.tj.service.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FootprintServiceImpl extends ServiceImpl<FootprintMapper, HappysysFootprint> implements FootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public List<HappysysProduct> getFootprintProductByUserId(Integer userId){

        return footprintMapper.getFootprintProductByUserId(userId);
    }

}
