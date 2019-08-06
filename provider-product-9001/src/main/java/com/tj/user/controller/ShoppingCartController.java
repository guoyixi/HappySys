package com.tj.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tj.product.HappysysShoppingCart;
import com.tj.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;


    @RequestMapping(value = "/HappysysShoppingCart/delShoppingCartByShoppingCartId/{shoppingCartId}")
    @ResponseBody
    public boolean delShoppingCartByShoppingCartId(@PathVariable("shoppingCartId") Integer shoppingCartId){
        System.out.println("ProductController      delShoppingCartByShoppingCartId");

        return shoppingCartService.removeById(shoppingCartId);
    }

    @RequestMapping(value = "/HappysysShoppingCart/delShoppingCartByProductIdAndUserId/{productId}/{userId}")
    @ResponseBody
    public boolean delShoppingCartByProductIdAndUserId(@PathVariable("productId") Integer productId,@PathVariable("userId") Integer userId){
        System.out.println("ProductController      delShoppingCartByProductIdAndUserId");
        Map<String,Object> params = new HashMap<>();
        params.put("shopping_cart_product_id",productId);
        params.put("shopping_cart_user_id",userId);

        return shoppingCartService.removeByMap(params);
    }


    @RequestMapping("/HappysysShoppingCart/getShoppingCartByProductIdAndUserId/{productId}/{userId}")
    @ResponseBody
    public HappysysShoppingCart getShoppingCartByProductIdAndUserId(@PathVariable("productId")Integer productId,@PathVariable("userId") Integer userId){
        System.out.println("ShoppingCartController      yongHuShiFouJiaRuGouWuChe");
        Map<String,Integer> params = new HashMap<>();
        params.put("shopping_cart_product_id",productId);
        params.put("shopping_cart_user_id",userId);
        QueryWrapper queryWrapper= new QueryWrapper();
        queryWrapper.allEq(params);
        return shoppingCartService.getOne(queryWrapper);
    }

    @RequestMapping("/HappysysShoppingCart/addShoppingCart")
    @ResponseBody
    public boolean addShoppingCart(@RequestBody HappysysShoppingCart shoppingCart){
        System.out.println("ShoppingCartController      addShoppingCart");

        return shoppingCartService.save(shoppingCart);
    }



}
