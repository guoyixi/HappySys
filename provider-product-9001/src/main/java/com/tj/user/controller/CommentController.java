package com.tj.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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




}
