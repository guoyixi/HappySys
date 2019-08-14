package com.tj.product.controller;

import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    public HappysysProductClientService productClientService;


    @RequestMapping("/HappysysOrder/loadOrderList")
    public String loadOrderList(){
        System.out.println("OrderController      loadOrderList");

        return "order-list";
    }



}
