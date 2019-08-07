package com.tj.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tj.product.HappysysClassify;
import com.tj.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    @RequestMapping("classify/list")
    @ResponseBody
    public List<HappysysClassify> classifyList(){
        System.out.println("进入classify");
        List<HappysysClassify> classify_parent_id=classifyService.list(new QueryWrapper<HappysysClassify>().eq("classify_parent_id", 0));
        for (HappysysClassify hc:classify_parent_id){
            System.out.println("hc.getClassifyId():"+hc.getClassifyId());
            hc.setChild(classifyService.list(new QueryWrapper<HappysysClassify>().eq("classify_parent_id",hc.getClassifyId())));
        }
        return classify_parent_id;
    }

}
