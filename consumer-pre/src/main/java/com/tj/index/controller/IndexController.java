package com.tj.index.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysProduct;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private HappysysProductClientService happysysProductClientService;

    @RequestMapping("/kuaixun")
    public String kuaixuan(Model model){
        System.out.println("进入Quickly");
        model.addAttribute("categoryList",happysysProductClientService.list());
        model.addAttribute("classifyList",happysysProductClientService.classifyList());
        return "Quickly";
    }
    @RequestMapping("/kuaixun/id/{classify_id}")
    @ResponseBody
    public String idclassify_id(@PathVariable Integer classify_id,Model model){
        System.out.println("aaaaaaaaaaaaaaaaaaa.."+classify_id);
        Map<String,Object> map=new HashMap<>();
        map.put("classify_id",classify_id);
        Page<HappysysProduct> productByMap = happysysProductClientService.getProductByMap(map);
        List<HappysysProduct> records = productByMap.getRecords();
        for (HappysysProduct ph:records){
            ph.setHappysysFeature(happysysProductClientService.productFeature(ph.getProductId()));
        }
        String json=JSON.toJSONString(productByMap);
        System.out.println("json:"+json);
        return json;
    }
}
