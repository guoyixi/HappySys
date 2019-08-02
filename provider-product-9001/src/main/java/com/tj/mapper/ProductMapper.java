package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tj.product.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper extends BaseMapper<HappysysProduct> {

    List<HappysysProduct> getByMap(@Param("conditions") Map<String, Object> conditions, IPage page);

    List<HappysysDeadline> getDeadline(Integer productId);
    List<HappysysSection> getSection(Integer productId);
    List<HappysysFeature> getFeature(Integer productId);
    List<HappysysInsurance> getInsurance(Integer productId);
    List<HappysysInsuranceSum> getInsuranceSum(Integer productId);
    List<HappysysPayment> getPayment(Integer productId);

    Double calculatePrice(Map<String,Object> map);



    /**
     * 评论数
     * @param productId
     * @return
     */
    Integer commentCount(Integer productId);

    /**
     * 订单数
     * @param productId
     * @return
     */
    Integer OrderCount(Integer productId);

    /**
     * 查询多个商品的保障去重复值
     * @param map
     * @return
     */
    List<HappysysInsurance> insuranceAll(@Param("conditions") Map<Object,String> map);
}
