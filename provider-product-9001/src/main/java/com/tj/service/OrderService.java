package com.tj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysOrder;

import java.util.List;
import java.util.Map;

public interface OrderService extends IService<HappysysOrder> {

    Map<String,Object> getAllOrderStatusNumByUserId(Integer userId);

    List<Map<String,Object>> getOrderByMap(Map<String,Object> conditions);

    Map<String,Object> getOrderByOrderId(Integer orderId);

}
