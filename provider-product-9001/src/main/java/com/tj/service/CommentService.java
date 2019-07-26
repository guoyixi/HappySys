package com.tj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysComment;

import java.util.Map;

public interface CommentService extends IService<HappysysComment>{

    IPage<Map<String,Object>> getCommentAndUserByProductId(Integer productId, Integer currentPage, Integer size);

}
