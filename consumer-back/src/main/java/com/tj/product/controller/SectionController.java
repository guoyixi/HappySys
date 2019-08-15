package com.tj.product.controller;

import com.tj.product.HappysysSection;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SectionController {

    @Autowired
    public HappysysProductClientService productClientService;


    @RequestMapping("/HappysysSection/getAllSection")
    @ResponseBody
    public List<HappysysSection> getAllSection(){

        return productClientService.getAllSection();
    }

    @RequestMapping("/HappysysSection/addSection")
    @ResponseBody
    public Boolean addSection(@RequestBody HappysysSection section){

        return productClientService.addSection(section);
    }

}
