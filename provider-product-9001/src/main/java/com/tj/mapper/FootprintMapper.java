package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.product.HappysysFootprint;
import com.tj.product.HappysysProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper extends BaseMapper<HappysysFootprint> {

    List<HappysysProduct> getFootprintProductByUserId(@Param("userId") Integer userId);


}
