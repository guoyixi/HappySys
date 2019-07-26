package com.tj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tj.product.HappysysProduct;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping("/HappysysProduct/getById/{productId}")
    public HappysysProduct getById(@PathVariable Integer productId){
        System.out.println("ProductController      getProductById");

        //根据ID查询商品
        HappysysProduct product = productService.getById(productId);
        //根据ID参训年龄
        product.setProductSectionList(productService.getSection(productId));
        //根据ID查询特色
        product.setProductFeatureList(productService.getFeature(productId));
        //根据ID查询保险
        product.setProductInsuranceList(productService.getInsurance(productId));

        return product;
    }

    @RequestMapping(value = "/HappysysProduct/getByMap" ,method = RequestMethod.POST)
    public IPage<HappysysProduct> getByMap(@RequestBody(required = false) Map<String,Object> condtions){
        System.out.println("CommentController      getListComment");

        Integer currentPage = condtions.get("currentPage") == null ? 1 : Integer.parseInt(condtions.get("currentPage")+"");
        Integer size = condtions.get("size") == null ? 6 : Integer.parseInt(condtions.get("size")+"");

        IPage<HappysysProduct> productPage = productService.getByMap(condtions,currentPage,size);

        System.out.println(condtions);
        //查询mongodb  ！！！！！！

        return productPage;
    }



}
