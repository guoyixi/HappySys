package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.product.HappysysCategory;

/**
 * 1:为了把mapper这个DAO交給Spring管理
 * 2:为了不再写mapper映射文件
 * 3:为了给mapper接口自动根据一个添加@Mapper注解的接口生成一个实现类
 */
public interface CategoryMapper extends BaseMapper<HappysysCategory> {


	
}
