package com.tj.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private HappysysProductClientService happysysProductClientService;


    @RequestMapping("/HappysysComment/getList/{productId}/{currentPage}/{size}")
    @ResponseBody
    public IPage<Map<String,Object>> getCommentAndUserByProductId(@PathVariable("productId") Integer productId, @PathVariable(value = "currentPage") Integer currentPage, @PathVariable(value = "size") Integer size){
        System.out.println("CommentController      getCommentAndUserByProductId");

        return happysysProductClientService.getCommentAndUserByProductId(productId,currentPage,size);
    }



}
