package com.tj.service;


import com.tj.product.HappysysCommonProblem;
import com.tj.product.HappysysPoduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("HAPPY-PRODUCT")
public interface HappysysProductClientService {

    @RequestMapping("/HappysysProduct/getById/{productId}")
    public HappysysPoduct getProductById(@PathVariable Integer productId);


    @RequestMapping("/HappysysProduct/getCommonProblemByProductId/{productId}")
    public List<HappysysCommonProblem> getCommonProblemByProductId(@PathVariable Integer productId);


}
