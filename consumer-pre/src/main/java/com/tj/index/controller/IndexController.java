package com.tj.index.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.HappysysFeature;
import com.tj.product.HappysysInsurance;
import com.tj.product.HappysysProduct;
import com.tj.service.HappysysProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import rx.observables.SyncOnSubscribe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        model.addAttribute("categoryList",happysysProductClientService.getCategoryAll());
        model.addAttribute("classifyList",happysysProductClientService.classifyList());
        //加载页面时显示产品和方案
        Map<String,Object> map=new HashMap<>();
        map.put("classify_id",13);
        Page<HappysysProduct> productByMap = happysysProductClientService.getProductByMap(map);
        List<HappysysProduct> records = productByMap.getRecords();
        for (HappysysProduct ph:records){
            ph.setProductFeatureList(happysysProductClientService.productFeature(ph.getProductId()));
        }
        model.addAttribute("productz",productByMap);
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
            ph.setProductFeatureList(happysysProductClientService.productFeature(ph.getProductId()));
        }
        String json=JSON.toJSONString(productByMap);
        System.out.println("json:"+json);
        return json;
    }


    @RequestMapping("/productlist/{productLevel3}/{pageIndex}")
    public ModelAndView productList(@PathVariable(value="productLevel3") Integer productLevel3,  @PathVariable(value="pageIndex") Integer pageIndex){
        System.out.println("nihao:"+productLevel3);
        if(pageIndex==0){
            pageIndex=1;
        }
        ModelAndView model=new ModelAndView();
        Page<HappysysProduct> productList = happysysProductClientService.productList2(productLevel3,pageIndex);
        model.addObject("productLista",productList);
        model.addObject("categoryList",happysysProductClientService.getCategoryAll());
        model.addObject("productLevel3",productLevel3);
        model.setViewName("product_list");
        return model;
    }

    @RequestMapping("/ajax/productlist/{productLevel3}/{pageIndex}")
    @ResponseBody
    public String ajaxPage(@PathVariable(value="productLevel3") Integer productLevel3,  @PathVariable(value="pageIndex") Integer pageIndex){
        if(pageIndex==0){
            pageIndex=1;
        }
        Page<HappysysProduct> productList = happysysProductClientService.productList2(productLevel3,pageIndex);
        String json=JSON.toJSONString(productList);
        System.out.println("json2:"+json);
        return json;
    }
}
