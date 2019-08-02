package com.tj.controller;

import com.tj.product.HappysysInsurance;
import com.tj.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping("/HappysysOrder/getInsuranceByOrderId/{orderId}")
    public List<HappysysInsurance> getInsuranceByOrderId(@PathVariable("orderId") Integer orderId){
        System.out.println("OrderController      getOrderByOrderId");

        return insuranceService.getInsuranceByOrderId(orderId);
    }


}
