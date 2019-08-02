package com.tj.product.controller;

import org.springframework.stereotype.Controller;
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

 @RequestMapping(value = "/HappysysPayment/payment1",method = RequestMethod.GET)
 public String payment(HttpSession session){

  Object user = session.getAttribute("user");
  if(user!=null){
   return "login";
  }

  return "product_payment1";
 }



}
