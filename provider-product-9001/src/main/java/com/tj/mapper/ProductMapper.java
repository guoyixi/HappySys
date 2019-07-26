package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;
import com.tj.product.HappysysProduct;
import com.tj.product.HappysysSection;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper extends BaseMapper<HappysysProduct> {

    List<HappysysProduct> getByMap(@Param("conditions") Map<String, Object> conditions, IPage page);

    List<HappysysSection> getSection(Integer productId);
    List<HappysysFeature> getFeature(Integer productId);
    List<HappysysInsurance> getInsurance(Integer productId);

}
