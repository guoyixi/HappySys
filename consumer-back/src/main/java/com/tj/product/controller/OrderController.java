package com.tj.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysApplicantInfo;
import com.tj.product.HappysysInsurance;
import com.tj.product.HappysysOrder;
import com.tj.product.util.MailUtil;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jfunc.json.impl.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    public HappysysProductClientService happysysProductClientService;


    @RequestMapping("/HappysysOrder/loadOrder")
    public String loadOrder(){
        System.out.println("OrderController      loadOrder");
        return "order-list";
    }


    @RequestMapping("/HappysysOrder/loadOrderList")
    @ResponseBody
    public String loadOrderList(@RequestParam Map<String,Object> map, Integer currentPage, Integer size){
        System.out.println("OrderController      loadOrderList"+currentPage+"\t"+size);
        System.out.println(map);

        Page<HappysysOrder> pg = happysysProductClientService.loadOrderList(map,currentPage,size);
        String s = JSON.toJSONStringWithDateFormat(pg.getRecords(), "yyyy-MM-dd", SerializerFeature.UseSingleQuotes);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","请求成功");
        jsonObject.put("count",pg.getTotal());
        jsonObject.put("data",s);

        System.out.println(jsonObject);

        return jsonObject.toString();
    }

    @RequestMapping("/HappysysOrder/loadOrderDetails")
    public String getOrderDetailsInfo(Model model, Integer orderId){
        //获取订单
        Map<String,Object> orderDetails = happysysProductClientService.getOrderByOrderId(orderId);

        Integer applicantId = Integer.parseInt(orderDetails.get("order_applicant_id")+"");
        Integer recognizeeId = Integer.parseInt(orderDetails.get("order_recognizee_id")+"");

        //获取当前投保人和被保人
        List<HappysysApplicantInfo> applicantAndrecognizeeList =  happysysProductClientService.getApplicantByIds(Arrays.asList(applicantId,recognizeeId));

        HappysysApplicantInfo applicantInfo = new HappysysApplicantInfo();
        HappysysApplicantInfo recognizeeInfo = new HappysysApplicantInfo();

        if(applicantAndrecognizeeList != null){
            if(applicantAndrecognizeeList.size() == 1){//如果size等于1那就代表投保人和被保人是同一个人
                applicantInfo = applicantAndrecognizeeList.get(0);
                recognizeeInfo = applicantAndrecognizeeList.get(0);
            }else {
                for (HappysysApplicantInfo applicantAndrecognizee : applicantAndrecognizeeList) {
                    if(applicantId.equals(applicantAndrecognizee.getApplicantId()) ) {
                        applicantInfo = applicantAndrecognizee;
                    }else {
                        recognizeeInfo = applicantAndrecognizee;
                    }
                }
            }
        }
        //根据 orderid获取所有的投保项
        List<HappysysInsurance> insuranceList =  happysysProductClientService.getInsuranceByOrderId(orderId);

        model.addAttribute("insuranceList",insuranceList);
        model.addAttribute("orderDetails",orderDetails);
        model.addAttribute("applicantInfo",applicantInfo);
        model.addAttribute("recognizeeInfo",recognizeeInfo);

        return "order-details";
    }

    @RequestMapping("/HappysysUser/emailOrderValidate")
    @ResponseBody
    public Integer emailValidate( HappysysOrder order){
        System.out.println("UserController      emailValidate");
        System.out.println("email："+order);

        new Thread(new MailUtil("xll1197578609@163.com", "尊敬的 用户 您好: \n" +
         "您于"+order.getOrderTime()+"购买的 开心保产品，订单号（"+order.getOrderNumber()+"）已经确认。\n" +
         "请前往个人中心立即支付！")).start();
        return 0;
    }

    @RequestMapping("/HappysysUser/updateOrderStatus")
    @ResponseBody
    public Integer updateOrderStatus(@RequestBody HappysysOrder order){
        System.out.println("UserController      updateOrderStatus");
        System.out.println("updateOrderStatus："+order);
        order.setOrderStatus(3);

        happysysProductClientService.updateOrder(order);
        return 0;
    }



}
