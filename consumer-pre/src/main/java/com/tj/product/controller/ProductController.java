package com.tj.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysProduct;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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


    @RequestMapping("/HappysysProduct/loadProductDetailsById/{productId}")
    public ModelAndView loadProductDetailsById(@PathVariable("productId") Integer productId){
        System.out.println("ProductController      loadProductDetailsById");

        ModelAndView mav = new ModelAndView();
        Page<Map<String,Object>> commentAndUserPage = happysysProductClientService.getCommentAndUserByProductId(productId,1,3);
        mav.addObject("commentAndUserPage", commentAndUserPage);
        mav.setViewName("user_comment");
        return mav;
    }


    @RequestMapping(value = "/HappysysProduct/loadShoppingCart")
    public ModelAndView loadShoppingCart(@RequestParam(required = false) Map<String,Object> condtions){
        System.out.println("ProductController      loadShoppingCart：");
        System.out.println(condtions);

        ModelAndView mav = new ModelAndView();
        mav.addObject("productPage", happysysProductClientService.getProductByMap(condtions));
        mav.setViewName("shopping_cart");

        return mav;
    }



}
