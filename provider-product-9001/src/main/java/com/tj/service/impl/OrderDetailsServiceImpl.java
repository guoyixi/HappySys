package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.OrderDetailsMapper;
import com.tj.product.HappysysOrderDetails;
import com.tj.service.OrderDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: HappySys
 * @Date: 2019/8/12 13:14
 * @Author: Mr.Deng
 * @Description:
 */
@Service
@Transactional
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsMapper, HappysysOrderDetails> implements OrderDetailsService {
}
