package com.tj.controller;

import com.tj.product.HappysysFeature;
import com.tj.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @RequestMapping("/HappysysDeadline/getAllFeature")
    public List<HappysysFeature> getAllFeature(){

        return featureService.getAllFeature();
    }

}
