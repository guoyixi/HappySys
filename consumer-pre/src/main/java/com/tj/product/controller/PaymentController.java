package com.tj.product.controller;

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

 @RequestMapping(value = "/HappysysPayment/payment1/{product}/{totolPrice}/{deadline}/{insurance}",method = RequestMethod.GET)
 public String payment(@PathVariable("product") String product,@PathVariable("totolPrice") Double totolPrice,@PathVariable("deadline") String deadline,@PathVariable("insurance") String insurance,  HttpSession session){

  System.out.println(product+totolPrice+deadline+insurance);

/*  Object user = session.getAttribute("user");
  if(user==null){
   return "redirect:/login.html";
  }*/
  return "product_payment1.html";
 }



}
