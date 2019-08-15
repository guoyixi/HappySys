package com.tj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @RequestMapping(value = "/HappysysOrder/loadOrderList",method = RequestMethod.POST)
    public IPage<HappysysOrder> loadOrderList(@RequestBody Map<String,Object> map, Integer currentPage, Integer size){

        System.out.println("=============="+map);
        QueryWrapper<HappysysOrder> queryWrapper = new QueryWrapper<>();
        if(map.get("startDate")!=null&&!map.get("startDate").equals("")){
            queryWrapper.and(i -> i.ge("order_time",map.get("startDate")));
        }
        if(map.get("endDate")!=null&&!map.get("endDate").equals("")){
            queryWrapper.and(i -> i.le("order_expire_time",map.get("endDate")));
        }
        if(map.get("price_min")!=null&&!map.get("price_min").equals("")){
            queryWrapper.and(i -> i.ge("order_face_amount",map.get("price_min")));
        }
        if(map.get("price_max")!=null&&!map.get("price_max").equals("")){
            queryWrapper.and(i -> i.le("order_face_amount",map.get("price_max")));
        }
        if(map.get("modules")!=null&&!map.get("modules").equals("")){
            queryWrapper.and(i -> i.eq("order_status",map.get("modules")));
        }

        Page<HappysysOrder> pg = new Page<>(currentPage,size);
        return orderService.page(pg,queryWrapper);

    }



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
