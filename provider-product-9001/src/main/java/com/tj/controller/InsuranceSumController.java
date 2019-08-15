package com.tj.controller;

import com.tj.product.HappysysInsuranceSum;
import com.tj.service.InsuranceSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuranceSumController {

    @Autowired
    private InsuranceSumService insuranceSumService;

    @RequestMapping("/HappysysOrder/getAllInsuranceSum")
    public List<HappysysInsuranceSum> getAllInsuranceSum(){

        return insuranceSumService.list();
    }


}
