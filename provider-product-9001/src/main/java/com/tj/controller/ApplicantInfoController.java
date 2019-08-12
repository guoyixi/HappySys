package com.tj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tj.product.HappysysApplicantInfo;
import com.tj.product.HappysysApplicantInfoModel;
import com.tj.service.ApplicantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     *查询此用户的所有被保人
     * @param userId
     * @return
     */
    @RequestMapping("/HappysysApplicantInfo/getApplicantByUserId")
    public List<HappysysApplicantInfo> getApplicantByUserId(Integer userId){
        System.out.println("getApplicantByUserId"+userId);
        return applicantInfoService.list(new QueryWrapper<HappysysApplicantInfo>().eq("applicant_user_id",userId));
    }

    /**
     *查询投保人 Just One
     * @param applicantId
     * @return
     */
    @RequestMapping("/HappysysApplicantInfo/getApplicantByApplicatnId")
    public HappysysApplicantInfo getApplicantByApplicatnId(Integer applicantId){
        return applicantInfoService.getById(applicantId);
    }

    @RequestMapping(value = "/HappysysApplicantInfo/operationApplicationInfo", method = RequestMethod.POST)
    public Integer[] operationApplicationInfo(@RequestBody HappysysApplicantInfoModel happysysApplicantInfoModel) {

        Integer[] l = new Integer[2];

        List<HappysysApplicantInfo> list = happysysApplicantInfoModel.getList();

        //投保人And被保人
        HappysysApplicantInfo applicant = list.get(0);
        HappysysApplicantInfo recognizee = list.get(1);

        applicantInfoService.saveOrUpdate(applicant);
        l[0] = applicant.getApplicantId();
        System.out.println(l[0]);

        applicantInfoService.saveOrUpdate(recognizee);
        l[1] = recognizee.getApplicantId();
        System.out.println(l[1]);

        return l;

    }


    @RequestMapping("/HappysysApplicantInfo/delApplicantById")
    public Boolean delApplicantById(Integer applicantId){
        System.out.println("ApplicantInfoController      delApplicantById：");
        System.out.println(applicantId);

        return applicantInfoService.removeById(applicantId);
    }

}
