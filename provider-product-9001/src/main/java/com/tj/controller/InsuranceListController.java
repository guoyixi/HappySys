package com.tj.controller;

import com.tj.product.HappysysInsuranceList;
import com.tj.service.InsuranceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuranceListController {

    @Autowired
    private InsuranceListService insuranceServiceList;


    @RequestMapping("/HappysysOrder/addInsuranceList")
    public Boolean addInsuranceList(@RequestBody HappysysInsuranceList insurance){
        System.out.println("InsuranceListController      addInsuranceList");

        return insuranceServiceList.save(insurance);
    }

}
