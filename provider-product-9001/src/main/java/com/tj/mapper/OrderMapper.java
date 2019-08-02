package com.tj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tj.product.HappysysOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper extends BaseMapper<HappysysOrder> {

    Map<String,Object> getAllOrderStatusNumByUserId(@Param("userId") Integer userId);

    List<Map<String,Object>> getOrderByMap(@Param("conditions") Map<String,Object> conditions);

    Map<String,Object> getOrderByOrderId(@Param("orderId") Integer orderId);

}
