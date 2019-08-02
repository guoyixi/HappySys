package com.tj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.*;

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
