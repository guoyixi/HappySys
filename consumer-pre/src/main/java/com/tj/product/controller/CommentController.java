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

import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private HappysysProductClientService happysysProductClientService;


    @RequestMapping("/HappysysComment/getList/{productId}/{currentPage}/{size}")
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

        //查询常见列表
        List<HappysysCommonProblem> commonProblemList = happysysProductClientService.getCommonProblemByProductId(productId);


        mav.addObject("commentAndUserPage", commentAndUserPage);
        mav.addObject("commonProblemList", commonProblemList);
        mav.addObject("commentSatisfaction", commentSatisfaction);

        mav.setViewName("user_comment2");
        return mav;
    }



}
