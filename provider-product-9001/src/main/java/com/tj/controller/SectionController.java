package com.tj.controller;

import com.tj.product.HappysysSection;
import com.tj.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @RequestMapping("/HappysysSection/getAllSection")
    public List<HappysysSection> getAllSection(){

        return sectionService.list();
    }

    @RequestMapping("/HappysysSection/addSection")
    public Boolean addSection(@RequestBody HappysysSection section){

        return sectionService.save(section);
    }
}
