package com.tj.product.controller;

import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingCartController {

    @Autowired
    private HappysysProductClientService happysysProductClientService;

    @RequestMapping("/HappysysShoppingCart/delShoppingCartByShoppingCartId/{shoppingCartId}")
    @ResponseBody
    public boolean delShoppingCartByShoppingCartId(@PathVariable("shoppingCartId")Integer shoppingCartId){
        System.out.println("ShoppingCartController      delShoppingCartByShoppingCartId");

        return happysysProductClientService.delShoppingCartByShoppingCartId(shoppingCartId);
    }


}
