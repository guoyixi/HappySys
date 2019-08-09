package com.tj.product.controller;

import com.tj.product.HappysysApplicantInfo;
import com.tj.service.ApplicantInfoService;
import com.tj.user.HappysysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: HappySys
 * @Date: 2019/8/1 11:01
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class PaymentController {

 @Autowired
 private ApplicantInfoService applicantInfoService;

 @RequestMapping(value = "/HappysysPayment/payment1",method = RequestMethod.POST)
 public ModelAndView paymentOne(@RequestParam Map<String,Object> map, HttpSession session){

  ModelAndView modelAndView = new ModelAndView();
  HappysysUser user = (HappysysUser)session.getAttribute("user");
  if(user==null){
   modelAndView.setViewName("redirect:/login.html");
  }else{
   modelAndView.addObject("map",map);
   if(user.getUserApplicantInfoId()!=null&&user.getUserApplicantInfoId()!=0){
    modelAndView.addObject("applicant",applicantInfoService.getById(user.getUserApplicantInfoId()));
   }
   modelAndView.setViewName("product_payment1.html");
  }
  return modelAndView;
 }


 @RequestMapping(value = "/HappysysPayment/payment2",method = RequestMethod.POST)
 public String paymentTwo(HappysysApplicantInfo sdinformationAppnt, HappysysApplicantInfo sdinformationinsured,HttpSession session) {



  System.out.println("/HappysysPayment/payment2:"+sdinformationAppnt+"\t"+sdinformationinsured);
  //判断User外键 ==null 新增投保人/修改用户表外键

  //新增被保人 applicant_info  apllcatn_info_center

  //订单


  return "product_payment2.html";
 }


}
