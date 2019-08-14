package com.tj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.*;
import com.tj.vo.HappysysProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductService extends IService<HappysysProduct> {


    IPage<HappysysProduct> getByMap(Map<String,Object> conditons, Integer currentPage, Integer size);

    List<HappysysDeadline> getDeadline(Integer productId);
    List<HappysysSection> getSection(Integer productId);
    List<HappysysFeature> getFeature(Integer productId);
    List<HappysysInsurance> getInsurance(Integer productId);
    List<HappysysInsuranceSum> getInsuranceSum(Integer productId);
    List<HappysysPayment> getPayment(Integer productId);

    Double calculatePrice(Map<String,Object> map);
    List<HappysysSection> findListidSection(@Param("sectionListid") Integer sectionListid);
    List<HappysysDeadline> findListidDeadline(Integer deadlineListid);
    List<HappysysInsuranceSum> findinsurancesum(Integer insurancesumListid);
    List<HappysysFeature> findFeatureListid(Integer findfeaturelistid);
    List<HappysysInsuranceList> showAllInsuranceList();
    List<HappysysInsurance> findInsuranceListid(Integer findinsurancetListid);
    boolean productinsert(HappysysProductVo productvo);
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

    List<HappysysInsurance> insuranceAll(Map<Object,String> map);
}
