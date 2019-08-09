package com.tj.product.controller;

import com.tj.product.HappysysApplicantInfo;
import com.tj.product.HappysysProduct;
import com.tj.service.HappysysProductClientService;
import com.tj.user.HappysysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
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
 private HappysysProductClientService happysysProductClientService;

 @RequestMapping(value = "/HappysysPayment/payment1",method = RequestMethod.POST)
 public String paymentOne(@RequestParam Map<String,Object> map, @RequestParam("insuranceList") List<Integer> insuranceList, Model model, HttpSession session){

  model.addAttribute("map",map);
  model.addAttribute("insuranceList",insuranceList);

  /*  HappysysUser user = (HappysysUser)session.getAttribute("user");*/

  HappysysUser user = new HappysysUser();
  user.setUserId(18);
  user.setUserApplicantInfoId(1);

  if(user==null){
   return "redirect:/login.html";
  }else{
   if(user.getUserApplicantInfoId()!=null&&user.getUserApplicantInfoId()!=0){
    model.addAttribute("applicant",happysysProductClientService.getApplicantByApplicatnId(user.getUserApplicantInfoId()));
   }else{
    model.addAttribute("applicant",null);
   }
    model.addAttribute("recognizee",happysysProductClientService.getApplicantByUserId(user.getUserId()));
  }
  return "product_payment1";
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
