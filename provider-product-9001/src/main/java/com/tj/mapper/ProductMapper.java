package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tj.product.*;
import com.tj.vo.HappysysProductVo;
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

    Double calculatePrice(Map<String,Object> map);
    List<HappysysSection> findListidSection(@Param("sectionListid") Integer sectionListid);
    List<HappysysDeadline> findListidDeadline(Integer deadlineListid);
    List<HappysysInsuranceSum> findinsurancesum(Integer insurancesumListid);
    List<HappysysFeature> findFeatureListid(Integer findfeaturelistid);
    List<HappysysInsuranceList> showAllInsuranceList();
    List<HappysysInsurance> findInsuranceListid(Integer findinsurancetListid);
    boolean productinsert(@Param("productvo") HappysysProductVo productvo);
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
