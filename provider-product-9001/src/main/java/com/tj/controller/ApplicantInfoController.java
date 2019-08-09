package com.tj.controller;

import com.tj.product.HappysysApplicantInfo;
import com.tj.service.ApplicantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicantInfoController {

    @Autowired
    private ApplicantInfoService applicantInfoService;

    @RequestMapping("/HappysysApplicantInfo/getApplicantByIds")
    @ResponseBody
    public List<HappysysApplicantInfo> getApplicantByIds(@RequestBody List<Integer> applicantIds){
        System.out.println("ApplicantInfoController      getApplicantByIds");

        return ((List<HappysysApplicantInfo>)applicantInfoService.listByIds(applicantIds));
    }


}
