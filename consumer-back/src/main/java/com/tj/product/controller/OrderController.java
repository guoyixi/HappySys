package com.tj.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysOrder;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jfunc.json.impl.JSONObject;

import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    public HappysysProductClientService productClientService;


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

        Page<HappysysOrder> pg = productClientService.loadOrderList(map,currentPage,size);
        String s = JSON.toJSONStringWithDateFormat(pg.getRecords(), "yyyy-MM-dd", SerializerFeature.UseSingleQuotes);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","请求成功");
        jsonObject.put("count",pg.getTotal());
        jsonObject.put("data",s);

        System.out.println(jsonObject);

        return jsonObject.toString();
    }




}
