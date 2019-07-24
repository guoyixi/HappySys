package com.tj.controller;


import com.tj.product.HappysysCommonProblem;
import com.tj.service.CommonProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommonProblemController {

    @Autowired
    private CommonProblemService commonProblemService;

    @RequestMapping("/HappysysCommonProblem/getByProductId/{productId}")
    @ResponseBody
    public List<HappysysCommonProblem> getCommonProblemByProductId(@PathVariable Integer productId){
        System.out.println("CommonProblemController     getCommonProblemByProductId");

        return commonProblemService.getCommonProblemByProductId(productId);
    }


}
