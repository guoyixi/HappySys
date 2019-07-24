package com.tj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tj.product.HappysysComment;
import com.tj.product.HappysysPoduct;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface CommentService extends IService<HappysysComment>{

    IPage<Map<String,Object>> getCommentAndUserByProductId(Integer productId, Integer currentPage, Integer size);

}
