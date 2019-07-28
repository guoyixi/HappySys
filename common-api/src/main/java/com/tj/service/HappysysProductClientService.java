package com.tj.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    HappysysProduct getProductById(@PathVariable("productId") Integer productId);


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
    Page<Map<String,Object>> getCommentAndUserByProductId(
            @PathVariable("productId") Integer productId,
            @PathVariable(value = "currentPage") Integer currentPage,
            @PathVariable(value = "size") Integer size);


    /* *
     * @param condtions     条件map 要加条件把键值put即可 然后就去product_mapper.xml中加条件
     *                       (ps：现已有：product_level1、product_level2、product_level3、shopping_cart_user_id
     *                                  、currentPage:默认为1、size:默认为6、  )
     * @return              返回page信息，和商品list
     */
    @RequestMapping(value = "/HappysysProduct/getByMap",method = RequestMethod.POST)
    Page<HappysysProduct> getProductByMap(@RequestBody(required = false) Map<String,Object> condtions);



    @RequestMapping(value = "/HappysysCategory/get/{id}",method = RequestMethod.GET)
    List<HappysysCategory> get(@PathVariable("id") Integer categoryId);

    @RequestMapping(value = "/HappysysCategory/list",method = RequestMethod.GET)
    List<HappysysCategory> list();

    @RequestMapping(value = "/HappysysCategory/add",method = RequestMethod.POST)
    boolean add(HappysysCategory happysysCategory);


    @RequestMapping("/classify/list")
    List<HappysysClassify> classifyList();

    @RequestMapping(value = "/HappsysProduct/getFeature/{product_id}")
    List<HappysysFeature> productFeature(@PathVariable("product_id") Integer product_id);

    /**
     *                          根据购物车id删除单条购物车记录
     * @param shoppingCartId    购物车id
     * @return                  返回是否成功
     */
    @RequestMapping(value = "/HappysysShoppingCart/delShoppingCartByShoppingCartId/{shoppingCartId}")
    boolean delShoppingCartByShoppingCartId(@PathVariable("shoppingCartId") Integer shoppingCartId);


}
