package com.tj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.product.HappysysCommonProblem;
import com.tj.mapper.CommonProblemMapper;
import com.tj.service.CommonProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommonProblemServiceImpl extends ServiceImpl<CommonProblemMapper, HappysysCommonProblem> implements CommonProblemService{

    @Autowired
    private CommonProblemMapper commonProblemMapper;

    @Override
    public List<HappysysCommonProblem> getCommonProblemByProductId(Integer productId){

        return commonProblemMapper.selectList(new QueryWrapper<HappysysCommonProblem>().eq("commonp_product_id", productId));
    }

}
