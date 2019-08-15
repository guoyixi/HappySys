package com.tj.product.controller;

import com.tj.product.HappysysInsurance;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InsuranceController {

    @Autowired
    public HappysysProductClientService productClientService;


    @RequestMapping("/HappysysInsurance/getAllInsurance")
    @ResponseBody
    public List<HappysysInsurance> getAllInsurance(){
        System.out.println("InsuranceController      getAllInsurance");

        return productClientService.getAllInsurance();
    }

    @RequestMapping("/HappysysInsurance/addInsurance")
    @ResponseBody
    public Boolean addInsurance(@RequestBody HappysysInsurance insurance){
        System.out.println("InsuranceController      addInsurance");

        return productClientService.addInsurance(insurance);
    }

}
