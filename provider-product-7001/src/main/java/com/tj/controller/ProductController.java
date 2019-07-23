package com.tj.controller;

import com.tj.product.HappysysPoduct;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping("/HappysysProduct/getById/{productId}")
    @ResponseBody
    public HappysysPoduct getProductById(@PathVariable Integer productId){
        System.out.println("ProductController      getProductById");

        HappysysPoduct product = productService.getById(productId);

        Map<String,Object> mongoData = mongoTemplate.findById(productId, Map.class, "happysys_product");
        product.setMongoData(mongoData);

        return product;
    }



}
