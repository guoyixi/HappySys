package com.tj.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysCommonProblem;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private HappysysProductClientService happysysProductClientService;


/*    @RequestMapping("/HappysysComment/getCommentAndUserByProductId/{productId}/{currentPage}/{size}")
    public ModelAndView getCommentAndUserByProductId(@PathVariable("productId") Integer productId, @PathVariable(value = "currentPage") Integer currentPage, @PathVariable(value = "size") Integer size){
        System.out.println("CommentController      getCommentAndUserByProductId");

        ModelAndView mav = new ModelAndView();
        Page<Map<String,Object>> commentAndUserPage = happysysProductClientService.getCommentAndUserByProductId(productId,currentPage,size);
        Integer commentSatisfaction = 100;

        //循环计算评价满意度
        List<Map<String,Object>> list = commentAndUserPage.getRecords();
        if(list != null && list.size() > 0){
            Integer totalGrade = 0;
            for(Map<String,Object>  map: list){
                totalGrade += (Integer)map.get("comment_grade");
            }
            //数量÷总数×100=百分比
            Double result = (totalGrade / (list.size() * 5.0) * 100);
            commentSatisfaction = result.intValue();
        }
        mav.addObject("commentAndUserPage", commentAndUserPage);
        mav.addObject("commentSatisfaction", commentSatisfaction);

        mav.setViewName("user_comment2");
        return mav;
    }*/



    @RequestMapping("/HappysysComment/getCommentAndUserByProductId/{productId}")
    @ResponseBody
    public Map<String,Object> getCommentAndUserByProductId(@PathVariable("productId") Integer productId){
        System.out.println("CommentController      getCommentAndUserByProductId  responseBody");

        Page<Map<String,Object>> commentAndUserPage = happysysProductClientService.getCommentAndUserByProductId(productId,1,99999);
        Integer commentSatisfaction = 100;

        //所有的评论所评价的user
        List<Map<String,Object>> commentAndUser = commentAndUserPage.getRecords();

        //循环计算评价满意度
        if(commentAndUser != null && commentAndUser.size() > 0){
            Integer totalGrade = 0;
            for(Map<String,Object>  map: commentAndUser){
                totalGrade += (Integer)map.get("comment_grade");
            }
            //数量÷总数×100=百分比
            Double result = (totalGrade / (commentAndUser.size() * 5.0) * 100);
            commentSatisfaction = result.intValue();
        }

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("commentAndUser",commentAndUser);
        resultMap.put("commentSatisfaction",commentSatisfaction);

        return resultMap;
    }


}
