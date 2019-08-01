package com.tj.product.controller;

import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private HappysysProductClientService happysysProductClientService;

    @RequestMapping("/HappysysProduct/getById/{productId}")
    public String getById(@PathVariable("productId") Integer productId,Model model){
        model.addAttribute("product",this.happysysProductClientService.getProductById(productId));
        return "product_details";
    }

    @RequestMapping(value = "/HappysysProduct/getCaluelatePrice",method = RequestMethod.POST)
    @ResponseBody
    public Double caluelatePrice(@RequestParam Map<String,Object> map){
        return this.happysysProductClientService.calculatePrice(map);
    }


}
