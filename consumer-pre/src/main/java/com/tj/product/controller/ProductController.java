package com.tj.product.controller;

import com.tj.product.HappysysPoduct;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private HappysysProductClientService happysysProductClientService;

    @RequestMapping("/HappysysProduct/getById/{productId}")
    @ResponseBody
    public HappysysPoduct getProductById(@PathVariable Integer productId){
        return happysysProductClientService.getProductById(productId);
    }

}
