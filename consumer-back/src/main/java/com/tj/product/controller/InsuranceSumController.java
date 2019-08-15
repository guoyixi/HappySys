package com.tj.product.controller;

import com.tj.product.HappysysInsuranceSum;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class InsuranceSumController {

    @Autowired
    public HappysysProductClientService productClientService;

    @RequestMapping("/HappysysInsuranceSum/getAllInsuranceSum")
    @ResponseBody
    public List<HappysysInsuranceSum> getAllInsuranceSum(){

        return productClientService.getAllInsuranceSum();
    }


}
