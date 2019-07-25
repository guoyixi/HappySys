package com.tj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tj.product.HappysysPoduct;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping("/HappysysProduct/getById/{productId}")
    @ResponseBody
    public HappysysPoduct getById(@PathVariable Integer productId){
        System.out.println("ProductController      getProductById");

        HappysysPoduct product = productService.getById(productId);

        Map<String,Object> mongoData = mongoTemplate.findById(productId, Map.class, "happysys_product");
        product.setMongoData(mongoData);

        return product;
    }

    @RequestMapping(value = "/HappysysProduct/getByMap" ,method = RequestMethod.POST)
    @ResponseBody
    public IPage<HappysysPoduct> getByMap(@RequestBody(required = false) Map<String,Object> condtions){
        System.out.println("CommentController      getListComment");

        Integer currentPage = condtions.get("currentPage") == null ? 1 : Integer.parseInt(condtions.get("currentPage")+"");
        Integer size = condtions.get("size") == null ? 6 : Integer.parseInt(condtions.get("size")+"");

        IPage<HappysysPoduct> productPage = productService.getByMap(condtions,currentPage,size);

        System.out.println(condtions);
        //查询mongodb  ！！！！！！

        return productPage;
    }



}
