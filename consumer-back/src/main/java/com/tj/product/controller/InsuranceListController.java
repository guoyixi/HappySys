package com.tj.product.controller;

import com.tj.product.HappysysInsuranceList;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InsuranceListController {

    @Autowired
    public HappysysProductClientService productClientService;

    @RequestMapping("/HappysysInsuranceList/addInsuranceList")
    @ResponseBody
    public Boolean addInsuranceList(@RequestBody HappysysInsuranceList insurance){
        System.out.println("InsuranceListController      addInsuranceList");

        return productClientService.addInsuranceList(insurance);
    }

}
