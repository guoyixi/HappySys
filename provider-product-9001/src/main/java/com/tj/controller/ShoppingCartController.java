package com.tj.controller;

import com.tj.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
