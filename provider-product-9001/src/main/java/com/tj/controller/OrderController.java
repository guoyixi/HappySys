package com.tj.controller;

import com.tj.product.HappysysOrder;
import com.tj.product.HappysysOrderDetails;
import com.tj.service.OrderDetailsService;
import com.tj.service.OrderService;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

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

    @RequestMapping(value = "/HappysysOrder/insertOrder",method = RequestMethod.POST)
    public Integer insertOrder(@RequestBody HappysysOrder order){
        orderService.save(order);
        return order.getOrderId();
    }

    @RequestMapping(value = "/HappysysOrder/updateOrder",method = RequestMethod.POST)
    public boolean updateOrder(HappysysOrder order){
        return orderService.updateById(order);
    }


    @RequestMapping(value = "/HappysysOrder/insertOrderDetails",method = RequestMethod.POST)
    public Boolean insertOrderDetails(@RequestBody Collection<HappysysOrderDetails> happysysOrderDetails){
        return orderDetailsService.saveBatch(happysysOrderDetails);
    }


}
