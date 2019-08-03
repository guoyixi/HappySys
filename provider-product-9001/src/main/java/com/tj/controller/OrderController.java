package com.tj.controller;

import com.tj.service.OrderService;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/HappysysOrder/getAllOrderStatusNumByUserId/{userId}")
    public Map<String,Object> getAllOrderStatusNumByUserId(@PathVariable("userId") Integer userId){
        System.out.println("OrderController      getAllOrderStatusNumByUserId");
        
        return orderService.getAllOrderStatusNumByUserId(userId);
    }


    @RequestMapping("/HappysysOrder/getOrderByMap")
    public List<Map<String,Object>> getOrderByMap(@RequestParam Map<String,Object> conditions){
        System.out.println("OrderController      getAllOrderStatusNumByUserId");

        return orderService.getOrderByMap(conditions);
    }

    @RequestMapping("/HappysysOrder/getOrderByOrderId/{orderId}")
    public Map<String,Object> getOrderByOrderId(@PathVariable("orderId") Integer orderId){
        System.out.println("OrderController      getOrderByOrderId");

        return orderService.getOrderByOrderId(orderId);
    }


    @RequestMapping("/HappysysOrder/getOrderCountByProductId/{productId}")
    public Integer getOrderCountByProductId(@PathVariable("productId") Integer productId){
        System.out.println("OrderController      getOrderCountByProduct");

        return productService.OrderCount(productId);
    }


}
