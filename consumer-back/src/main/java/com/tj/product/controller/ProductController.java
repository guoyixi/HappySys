package com.tj.product.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.product.*;
import com.tj.service.HappysysProductClientService;
import com.tj.service.HappysysUserClientService;
import com.tj.vo.HappysysProductVo;
import javafx.scene.control.Alert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ProductController implements  ServletContextAware{
    @Autowired
    public HappysysProductClientService productClientService;

    private ServletContext application;
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.application=servletContext;
    }

    @RequestMapping("/ajax/productlist/{pageIndex}/{productnamelike}")
    @ResponseBody
    public String ajaxPage(@PathVariable(value="pageIndex") Integer pageIndex,@PathVariable(value = "productnamelike") String productnamelike){
        if(pageIndex==0){
            pageIndex=1;
        }
        Page<Map<String,Object>> productList = productClientService.showProductAll(pageIndex,productnamelike);
        String json= JSON.toJSONString(productList);
        System.out.println("json2:"+json);
        return json;
    }
    @RequestMapping("/ajax/section")
    @ResponseBody
    public List<Map<String, Object>> showallSection(){
        List<Map<String, Object>> jsonoList = new ArrayList<Map<String, Object>>();
        List<HappysysSectionList> happysysSectionLists = productClientService.showSectionAll();
        for (HappysysSectionList list:happysysSectionLists){
            Map<String,Object> map=new HashMap<>();
            map.put("id",list.getSectionListId());
            map.put("title",list.getSectionListName());
            List<HappysysSection> happysysSections = productClientService.findlistidSection(list.getSectionListId());
            map.put("children", happysysSections);
            jsonoList.add(map);
        }
        System.out.println("jsonlist:"+jsonoList);
        return jsonoList;
    }
    @RequestMapping("/ajax/dealinelist")
    @ResponseBody
    public List<Map<String,Object>> showalldealinelist(){
        List<Map<String, Object>> jsonoList = new ArrayList<Map<String, Object>>();

        List<HappysysDeadlineList> happysysDeadlineLists = productClientService.showalldealineList();
        for (HappysysDeadlineList deadlist:happysysDeadlineLists){
            Map<String,Object> map=new HashMap<>();
            map.put("id",deadlist.getDeadlineListId());
            map.put("title",deadlist.getDeadlineListName());
            map.put("children", productClientService.findlistiddeadline(deadlist.getDeadlineListId()));
            jsonoList.add(map);
        }
        return jsonoList;
    }
    @RequestMapping("/ajax/insuranceSumList")
    @ResponseBody
    public List<Map<String,Object>> showAllInsuranceSumList(){

        List<Map<String, Object>> jsonoList = new ArrayList<Map<String, Object>>();
        List<HappysysInsuranceSumList> happysysInsuranceSumLists = productClientService.showAllInsuranceSumList();
        for (HappysysInsuranceSumList ins:happysysInsuranceSumLists){
            Map<String,Object> map=new HashMap<>();
            map.put("id",ins.getInsuranceSumListId());
            map.put("title",ins.getInsuranceSumListName());
            map.put("children", productClientService.findInsurancesSum(ins.getInsuranceSumListId()));
            jsonoList.add(map);
        }
        System.out.println("insurancejsonlist:"+jsonoList);
        return jsonoList;

    }

    @RequestMapping("/ajax/featureList")
    @ResponseBody
    public List<Map<String,Object>> showAllFeatureList(){
        List<Map<String, Object>> jsonoList = new ArrayList<Map<String, Object>>();
        List<HappysysFeatureList> happysysFeatureLists = productClientService.showAllFeatureList();
        for (HappysysFeatureList feature :happysysFeatureLists){
            Map<String,Object> map=new HashMap<>();
            map.put("id",feature.getFeatureListId());
            map.put("title",feature.getFeatureListName());
            map.put("children", productClientService.findfeaturelistid(feature.getFeatureListId()));
            jsonoList.add(map);
        }
        return jsonoList;
    }
    @RequestMapping("/ajax/insurance_list")
    @ResponseBody
    public List<Map<String,Object>> showAllInsurancelist(){
        List<Map<String, Object>> jsonoList = new ArrayList<Map<String, Object>>();
        List<HappysysInsuranceList> happysysInsuranceLists = productClientService.showAllInsuranceList();
        for (HappysysInsuranceList ins:happysysInsuranceLists){
            Map<String,Object> map=new HashMap<>();
            map.put("id",ins.getInsuranceListId());
            map.put("title",ins.getInsuranceListName());
            map.put("children", productClientService.findinsurancetid(ins.getInsuranceListId()));
            jsonoList.add(map);
        }
        return jsonoList;
    }
    @RequestMapping("/ajax/category/{parentid}")
    @ResponseBody
    public List<HappysysCategory> findcategoryparentId(@PathVariable Integer parentid){
       return  productClientService.findcategoryparentId(parentid);
    }
    @RequestMapping("/product/add")
    public String addProduct(HappysysProductVo hproduct, MultipartFile file2) throws IllegalStateException, IOException {
        String Filename="";

        //上传到的路径
        String realPath = "D:/Y2/workspace_idea3/HappySys/consumer-back/src/main/resources/static/image";
        System.out.println("\trealPath:"+realPath);
        System.out.println("=============="+file2);
        List<String> asList = Arrays.asList("image/jpeg","image/gif","image/png");
        if(file2!=null) {
                    long millis=System.currentTimeMillis();//获取当前时间的毫秒
                    Filename = millis+file2.getOriginalFilename();//获取原始文件名
                    String contentType = file2.getContentType();//文件类型

                    System.out.println("Filename:"+Filename);
                    System.out.println("contentType:"+contentType);

                    if(asList.contains(contentType)) {
                        File df=new File(realPath,Filename);
                        //将内存文件写入硬盘

                        file2.transferTo(df);

                    }

        }

        hproduct.setProductImage(Filename);
        productClientService.addproduct(hproduct);//添加
        return "redirect:/product-brand.html";

    }


}
