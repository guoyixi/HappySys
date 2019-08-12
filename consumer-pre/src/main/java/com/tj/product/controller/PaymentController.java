package com.tj.product.controller;

import com.tj.product.HappysysApplicantInfoModel;
import com.tj.product.HappysysOrder;
import com.tj.product.HappysysOrderDetails;
import com.tj.service.HappysysProductClientService;
import com.tj.user.HappysysUser;
import com.tj.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
  user.setUserId(24);
  //user.setUserApplicantInfoId(1);

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
 public String paymentTwo(HappysysOrder order, @ModelAttribute("insuranceList") List<Integer> insuranceList,HappysysApplicantInfoModel list,HttpSession session) {


  System.out.println(order);

  System.out.println(insuranceList);

  System.out.println(list);

  //生成订单号
  order.setOrderNumber(UUIDUtil.getOrderIdByTime());

  //被保人操作
  Integer[] ids = happysysProductClientService.operationApplicationInfo(list);
  order.setOrderApplicantId(ids[0]);
  order.setOrderRecognizeeId(ids[1]);

  //订单详情
  Integer orderId = happysysProductClientService.insertOrder(order);
  List<HappysysOrderDetails> orderDetailsList = new ArrayList<>();
  for (Integer insuranceId : insuranceList) {
   HappysysOrderDetails happysysOrderDetails = new HappysysOrderDetails();
   happysysOrderDetails.setOrderDetailsOrderId(orderId);
   happysysOrderDetails.setOrderDetailsInsuranceId(insuranceId);
   orderDetailsList.add(happysysOrderDetails);
  }

  happysysProductClientService.insertOrderDetails(orderDetailsList);

  //判断User外键 ==null 新增投保人/修改用户表外键

  //新增被保人 applicant_info  apllcatn_info_center

  //订单

  return "forward:/HappysysOrder/loadProductPayment2/"+1;
 }


}
