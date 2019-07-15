package com.tj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysCommonProblem;

import java.util.List;

public interface CommonProblemService extends IService<HappysysCommonProblem> {


    List<HappysysCommonProblem> getCommonProblemByProductId(Integer productId);

}
