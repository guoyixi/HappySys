package com.tj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysComment;
import com.tj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping("/HappysysComment/getList/{productId}/{currentPage}/{size}")
    @ResponseBody
    public IPage<Map<String,Object>> getCommentAndUserByProductId(@PathVariable("productId") Integer productId,@PathVariable(value = "currentPage") Integer currentPage, @PathVariable(value = "size") Integer size){
        System.out.println("CommentController      getListComment");

        return commentService.getCommentAndUserByProductId(productId,currentPage,size);
    }


    @RequestMapping("/HappysysComment/addComment")
    @ResponseBody
    public boolean addComment(@RequestBody HappysysComment comment){
        System.out.println("CommentController      addComment");

        return commentService.save(comment);
    }





}
