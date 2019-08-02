package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.OrderMapper;
import com.tj.product.HappysysOrder;
import com.tj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends ServiceImpl<OrderMapper, HappysysOrder> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Map<String,Object> getAllOrderStatusNumByUserId(Integer userId){
        return orderMapper.getAllOrderStatusNumByUserId(userId);
    }

    @Override
    public List<Map<String,Object>> getOrderByMap(Map<String,Object> conditions){
        return orderMapper.getOrderByMap(conditions);
    }

    @Override
    public Map<String,Object> getOrderByOrderId(Integer orderId){
        return orderMapper.getOrderByOrderId(orderId);
    }

}
