package com.tj.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysCategory;
import com.tj.product.HappysysCommonProblem;
import com.tj.product.HappysysPoduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient("HAPPY-PRODUCT")
public interface HappysysProductClientService {

    /**
     * @param productId     商品id
     * @return              根据商品id查询商品
     */
    @RequestMapping("/HappysysProduct/getById/{productId}")
    HappysysPoduct getProductById(@PathVariable("productId") Integer productId);


    /**
     * @param productId
     * @return              根据productId商品的所有常见问题
     */
    @RequestMapping("/HappysysCommonProblem/getByProductId/{productId}")
    List<HappysysCommonProblem> getCommonProblemByProductId(@PathVariable("productId") Integer productId);


    /**
     * @param productId     商品id
     * @param currentPage   当前页
     * @param size          显示数量（ps：pageSize）
     * @return              返回page信息，和评论+用户的Map<String,Object>
     */
    @RequestMapping("/HappysysComment/getList/{productId}/{currentPage}/{size}")
    Page<Map<String,Object>> getCommentAndUserByProductId(@PathVariable("productId") Integer productId, @PathVariable(value = "currentPage") Integer currentPage, @PathVariable(value = "size") Integer size);

    @RequestMapping(value = "/HappysysCategory/get/{id}",method = RequestMethod.GET)
    public List<HappysysCategory> get(@PathVariable("id") Integer categoryId);

    @RequestMapping(value = "/HappysysCategory/list",method = RequestMethod.GET)
    public List<HappysysCategory> list();

    @RequestMapping(value = "/HappysysCategory/add",method = RequestMethod.POST)
    public boolean add(HappysysCategory happysysCategory);



}
