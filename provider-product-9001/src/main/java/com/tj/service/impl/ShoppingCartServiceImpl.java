package com.tj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.ShoppingCartMapper;
import com.tj.product.HappysysShoppingCart;
import com.tj.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, HappysysShoppingCart> implements ShoppingCartService {



}
