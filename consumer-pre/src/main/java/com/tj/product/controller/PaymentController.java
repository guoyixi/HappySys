package com.tj.product.controller;

import com.tj.product.HappysysApplicantInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @program: HappySys
 * @Date: 2019/8/1 11:01
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
public class PaymentController {

 @RequestMapping(value = "/HappysysPayment/payment1/{product}/{totolPrice}/{section}/{deadline}/{insurance}",method = RequestMethod.GET)
 public String paymentOne(@PathVariable("product") String product,@PathVariable("totolPrice") Double totolPrice,@PathVariable("section") String section,@PathVariable("deadline") String deadline,@PathVariable("insurance") String insurance,  HttpSession session){

/*  Object user = session.getAttribute("user");
  if(user==null){
   return "redirect:/login.html";
  }*/
 //判断User外键 !=null 查询投保人


  //Ajax 查询 被保人列表
  return "product_payment1.html";
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
