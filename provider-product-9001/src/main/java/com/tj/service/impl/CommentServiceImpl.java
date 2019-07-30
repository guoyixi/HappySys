package com.tj.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.mapper.CommentMapper;
import com.tj.product.HappysysComment;
import com.tj.service.CommentService;
import com.tj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl extends ServiceImpl<CommentMapper, HappysysComment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public IPage<Map<String,Object>> getCommentAndUserByProductId(Integer productId, Integer currentPage, Integer size){
        IPage page = new Page<>(currentPage,size);

        IPage<Map<String,Object>> resultPage = new Page<>();
        resultPage = page;
        resultPage.setRecords(commentMapper.getCommentAndUserByProductId(productId,page));
        return resultPage;
    }


}
